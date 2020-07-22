package com.aaa.service;

import cn.hutool.core.date.DateUtil;
import com.aaa.base.BaseService;
import com.aaa.mapper.PrincipalMapper;
import com.aaa.mapper.ResourceMapper;
import com.aaa.model.Principal;
import com.aaa.model.Resource;
import com.aaa.properties.FtpProperties;
import com.aaa.utils.FileNameUtils;
import com.aaa.utils.FtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.status.AddStatus.ADD_DATA_FAILED;
import static com.aaa.status.AddStatus.ADD_DATA_SUCCESS;
import static com.aaa.status.SelectStatus.SELECT_DATA_FAILED;
import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * @Company: AAA软件教育
 * @Author: Cancer:栗仁杰
 * @Date: Created in 2020/7/15 20:59
 * @Description:
 *           测绘管理-单位基本信息-负责人信息
 */
@Service
public class PrincipalService extends BaseService<Principal> {
    @Autowired
    private PrincipalMapper principalMapper;

    @Autowired
    private FtpProperties ftpProperties;

    @Autowired
    private ResourceMapper resourceMapper;
/**
 *@author: Cancer:栗仁杰
 *@description:获取负责人信息
 *@param: []
 *@date: 8:47 2020/7/18
 *@return:
 *@throws:
 **/
    public List<Principal> queryOne(Long userId){
        List<Principal> principal = principalMapper.queryOne(userId);
        if (principal != null) {
            return principal;
        }
        return null;
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:查询负责人信息
     *@param: []
     *@date: 9:01 2020/7/18
     *@return:
     *@throws:
     **/

    public Map<String,Object> selectPrincipalById(String id){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        Principal principal = principalMapper.selectPrincipalById(id);
        if (principal != null && !"".equals(principal)){
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",principal);
        }else{
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
        }
        return resultMap;
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:添加单位负责人
     *@param: []
     *@date: 8:50 2020/7/18
     *@return:
     *@throws:
     **/

    public Map<String, Object> addPrincipal(Principal principal, MultipartFile[] files, UploadService uploadService){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //设置负责人创建时间
        principal.setCreateTime(DateUtil.now());
        //生成一个id，用于负责人id
        String id = FileNameUtils.getFileName();
        principal.setId(Long.valueOf(id));
        //添加负责人
        int i = principalMapper.insertSelective(principal);
        if (i >0) {
            Boolean result = false;
            for (MultipartFile file: files) {
                //添加资源表
                Resource resource = new Resource();
                //设置资源ID
                String resourceId = FileNameUtils.getFileName();
                //获取今天日期格式化后的数据，用来当做路径
                String filePath = com.aaa.utils.DateUtils.formatDate(new Date(), "yyyy/MM/dd");
                //获取原始文件的名称
                String oldFilename = file.getOriginalFilename();
                System.out.println(oldFilename);
                //截取文件后缀
                String extName = oldFilename.substring(oldFilename.lastIndexOf("."));
                //生成新的文件名称
                String newFileName = resourceId + "" + extName;
                //设置resource对象的值
                resource.setName(file.getOriginalFilename()).setSize(Long.valueOf(file.getSize())).setPath(ftpProperties.getHttpPath()+filePath+"/"+newFileName)
                        .setType(file.getContentType()).setExtName(extName).setRefBizType("身份证").setRefBizId(Long.valueOf(id))
                        .setCreateTime(DateUtil.now()).setId(Long.valueOf(resourceId));
                //数据库添加resource的数据
                int r = resourceMapper.insert(resource);
                if (r >0) {
                    //添加成功后上传文件
                    result = uploadService.upload(file);
                }
            }
            if (result) {
                resultMap.put("code",ADD_DATA_SUCCESS.getCode());
                resultMap.put("msg",ADD_DATA_SUCCESS.getMsg());
                return resultMap;
            }
        }
        resultMap.put("code",ADD_DATA_FAILED.getCode());
        resultMap.put("msg",ADD_DATA_FAILED.getMsg());
        return resultMap;
    }

/**
 *@author: Cancer:栗仁杰
 *@description: 修改负责人信息
 *@param: []
 *@date: 11:51 2020/7/16
 *@return:
 *@throws:
 **/
    public Boolean updateList(Principal principal){
        //获取时间
        Date date = new Date();
        //设置时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date);
        //获取负责人信息
        Principal principal1 = principal.setId(principal.getId())
                .setType(principal.getType())
                .setName(principal.getName())
                .setIdNumber(principal.getIdNumber())
                .setAge(principal.getAge())
                .setSex(principal.getSex())
                .setMajor(principal.getMajor())
                .setDuty(principal.getDuty())
                .setModifyTime(format);
        if (null != principal1){
            int i = principalMapper.updateList(principal1);
            if (i>0){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:删除某个单位负责人信息
     *@param: []
     *@date: 9:08 2020/7/18
     *@return:
     *@throws:
     **/
    public int deletePrincipalById(String id) {
        //先删除负责人信息
        Principal principal = new Principal();
        principal.setId(Long.valueOf(id));
        int j = principalMapper.delete(principal);
        if (j > 0){
            //获取看资源表里有几个这个负责人的资源文件
            List<Resource> resources = resourceMapper.select(new Resource().setRefBizId(Long.valueOf(id)));
            //遍历获取每一个资源实体
            for (Resource resource : resources) {
                //删除这个实体和这个实体的ftp文件
                boolean b = FtpUtils.deleteFile(ftpProperties.getHost(), ftpProperties.getPort(), ftpProperties.getUsername(), ftpProperties.getPassword(), resource.getPath());
                int i = resourceMapper.delete(resource);
            }
            return 1;
        }
        return 0;
    }


}
