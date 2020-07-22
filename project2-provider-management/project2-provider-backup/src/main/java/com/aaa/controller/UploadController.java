package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName UploadController
 * @Description TODO 文件上传
 * @Author jyz
 * @date 2020/7/22 19:14
 **/
@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;

    /**
     * @Author jyz
     * @Description //TODO 文件上传
     * @Date 19:27 2020/7/22
     * @Param [file]
     * @return java.lang.Boolean
     **/
    @PostMapping("/upload")
    public Boolean upload(MultipartFile file){
        ResultData resultData = new ResultData();
        Boolean i = uploadService.upload(file);
        if (i == true){
           resultData.setCode("20021");
           resultData.setMsg("文件上传成功");
           return i;
        }else {
            resultData.setCode("40021");
            resultData.setMsg("文件上传失败");
            return false;
        }
    }
}
