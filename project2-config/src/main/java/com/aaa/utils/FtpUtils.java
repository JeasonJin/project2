package com.aaa.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

/**
 * @ClassName FtpUtils
 * @Description TODO
 * @Author jyzppp[[[[[[[[8
 * @date 2020/7/10 16:12
 **/
@Slf4j
public class FtpUtils {
    private FtpUtils(){

    }
    public static FTPClient getFtpClient(String host, int port, String username, String password){
        //创建FTPClient对象,这是ftp给java提供的api
        FTPClient ftpClient = new FTPClient();
        try {
            // 连接FTP服务器，如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftpClient.connect(host,port);
            // 登录FTP服务器
            ftpClient.login(username,password);
            // 如果登录成功，返回码是230。如果失败，则返回530/503
            int replyCode = ftpClient.getReplyCode();
            // 判断返回码是否合法，如果不合法说明账号和密码错误
            if (!FTPReply.isPositiveCompletion(replyCode)){
                log.info("未连接到FTP，用户名或密码错误。");
                //如果连接失败，释放资源
                ftpClient.disconnect();
                return null;
            }else {
                log.info("FTP连接成功。");
                return ftpClient;
            }
        } catch (SocketException e) {
            e.printStackTrace();
            log.info("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }


    /**
     * @Author jyz
     * @Description //TODO ftp文件上传方法工具
     * @Date 16:14 2020/7/10
     * @Param [host, port, username, password, basePath, filePath, fileName, inputStream]
     * @return java.lang.Boolean
     **/
    public static Boolean upload(String host, Integer port, String username, String password, String basePath,
                                 String filePath, String fileName, InputStream inputStream) {

        // 1.创建临时路径
        String tempPath = "";
        // 2.创建FTPClient对象(这个对象就是FTP给java所提供的API)
        FTPClient ftpClient = new FTPClient();
        try {
            // 3.定义返回状态码
            int replyCode;
            // 4.连接ftp
            ftpClient.connect(host, port);
            // 5.登录ftp服务器
            ftpClient.login(username, password);
            // 6.接收返回的状态码
            replyCode = ftpClient.getReplyCode();// 如果成功返回230，如果失败返回503
            // 7.判断
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                // 连接失败了
                ftpClient.disconnect();
                return false;
            }
            // 8.先检测我要上传的目录是否存在(2020/07/10)
            if (!ftpClient.changeWorkingDirectory(basePath + filePath)) {
                // 该文件夹不存在
                // 9.创建文件夹
                String[] dirs = filePath.split("/");// [2020, 07, 10] ["", "2020", "07", "10"]
                // 10.把basePath赋值给临时路径
                // tempPath:/home/ftp/www/
                tempPath = basePath;
                // 11.循环
                for (String dir : dirs) {
                    if (null == dir || StringUtils.isEmpty(dir)) {
                        // 没有数据
                        continue;
                    }
                    // 12.拼接临时路径(如果没有进入if，则取到的值应该就是2020)
                    tempPath += "/" + dir;
                    // tempPath: /home/ftp/www/2020
                    // 13.再次检测tempPath是否存在
                    if (!ftpClient.changeWorkingDirectory(tempPath)) {
                        // 文件夹不存在
                        // 14.创建文件夹
                        if (!ftpClient.makeDirectory(tempPath)) {
                            // 说明文件夹创建失败
                            return false;
                        } else {
                            // 15.严谨判断，判断创建出来的目录确实存在
                            ftpClient.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            // 16.把文件转换为二进制的形式来进行上传
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            // 17.这里才是真正的文件上传
            if (!ftpClient.storeFile(fileName, inputStream)) {
                // 说明上传失败
                return false;
            }
            // 18.关闭输入流
            inputStream.close();
            // 19.退出ftp
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    // 说明还在连接中(说明正在占用资源)
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return true;
    }

    /**
     * @Description: 上传文件，根据日期进行分文件夹上传
     * @Author: yao
     * @Date: 2020/7/15 19:39
     * @Param: [host, port, username, password, filePath, basePath, fileName, input]
     * @return: java.lang.Boolean
     */
    public static Boolean uploadFile(String host, Integer port, String username, String password,
                                     String filePath, String basePath, String fileName, InputStream input){
        //方便拼接路径
        String tmpPath = "";
        FTPClient ftpClient = null;
        try {
            //获取ftp连接，然后判断是否为null，不为空则连接成功，为null则返回false
            ftpClient = getFtpClient(host, port, username, password);
            if (null == ftpClient){
                return false;
            }
            //走到这里说明连接成功，开始进行检测要上传的文件夹是否存在
            //basePath + filePath---> /home/ftp/2020/05/15
            //changeWorkingDirectory():判断路径是否存在，如果存在返回true，如果不存在则返回false
            if (!ftpClient.changeWorkingDirectory(basePath+filePath)){
                //说明路径不存在，需要进行创建文件夹，java中创建文件夹需要一层层创建，所以需要线分割当前日期
                String[] dirs = filePath.split("/");
                //把basePath赋值给tmpPath
                tmpPath = basePath;
                //循环要创建的文件夹数组
                for (String dir : dirs) {
                    //文件夹不能为null，判断是否为空
                    if (null == dir || "".equals(dir)){
                        //如果为空，跳出当前循环，进入下一次
                        continue;
                    }
                    //否则拼接路径，如/home/ftp/2020
                    tmpPath += "/" + dir;
                    //再次检测确保路径不存在
                    if (!ftpClient.changeWorkingDirectory(tmpPath)){
                        //创建文件夹，返回为bolean，然后直接判断
                        if (!ftpClient.makeDirectory(tmpPath)){
                            return false;
                        }else{
                            log.info("创建文件夹路径：" + ftpClient.changeWorkingDirectory(tmpPath));
                        }
                    }
                }
            }
            //如果没有if进入或者从if中出来，证明文件夹已经有了，可以进行直接上传
            //FTP支持IO操作，但是IO效率没有二进制字符流高，把文件转换为二进制字符流上传
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //上传文件，storeFile():就是文件上传的方法，返回true/false
            if (!ftpClient.storeFile(fileName,input)){
                return false;
            }
            //关闭输入流
            input.close();
            //退出ftp
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()){
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    /**
     * 检验指定路径的文件是否存在ftp服务器中
     * @param filePath--指定绝对路径的文件
     * @return
     */
    public static boolean isFTPFileExist(final String hostname, final int port, final String username,
                                         final String password, final String filePath) {
        log.info("判断文件在ftp上是否存在！");
        boolean exists = false;
        final FTPClient ftpClient = getFtpClient(hostname, port, username, password);
        try {
            final FTPFile[] files = ftpClient.listFiles(new String(filePath.getBytes("UTF-8"), "ISO-8859-1"));
            if (files != null && files.length > 0) {
                exists = true;
            }
        } catch (final IOException e) {
            log.error("failed to judge whether the file (" + filePath + ") is existed");
        }
        log.info("文件" + filePath + "在ftp上是否存在?" + exists);
        return exists;
    }

/**
 *@author: Cancer:栗仁杰
 *@description:删除ftp的文件
 *@param: []
 *@date: 19:24 2020/7/21
 *@return:
 *@throws:
 **/
public static boolean deleteFile (final String hostname, final int port, final String username,
                                  final String password, final String ftpPath) {
    if (ftpPath != null && ftpPath != "") {
        final FTPClient ftpClient = getFtpClient(hostname, port, username, password);
        if (ftpPath.endsWith("/")) {
            log.info("错误的文件路径");
            return false;
        }
        try {
            final boolean exists = isFTPFileExist(hostname, port, username, password, ftpPath);
            if (exists) {
                ftpClient.deleteFile(new String(ftpPath.getBytes("GBK"), "iso-8859-1"));
            } else {
                log.info("文件" + ftpPath + "已经不存在");
                return true;
            }
        } catch (IOException e) {
            log.error("FTP上文件删除失败！", e);
            return false;
        }
    } else {
        log.info("没有需要删除的文件！");
    }
    return true;
}
}
