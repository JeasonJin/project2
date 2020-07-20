package com.aaa.utils;

import java.util.Random;

/**
 * @ClassName FileNameUtils
 * @Description TODO
 * @Author jyz
 * @date 2020/7/10 15:16
 **/
public class FileNameUtils {
    private FileNameUtils(){

    }
    public static String getFileName() {
        long currentTimeMillis = System.currentTimeMillis();
        Random random = new Random();
        int number = random.nextInt(999);
        return currentTimeMillis + String.format("%03d",number);
    }
    public static Long getFileNameLong(){
        //获取当前的毫秒数
        long timeMillis = System.currentTimeMillis();
        //随机生成一个999以内的数字
        Random random = new Random();
        Integer randomNum = random.nextInt(999999);
        Long fileName = timeMillis + randomNum;
        return fileName;
    }
}
