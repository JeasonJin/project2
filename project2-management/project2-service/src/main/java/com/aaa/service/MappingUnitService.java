package com.aaa.service;

import cn.hutool.core.date.DateUtil;
import com.aaa.mapper.MappingUnitMapper;
import com.aaa.mapper.ResourceMapper;
import com.aaa.model.MappingUnit;
import com.aaa.model.Resource;
import com.aaa.properties.FtpProperties;
import com.aaa.utils.FileNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.aaa.status.AddStatus.ADD_DATA_FAILED;
import static com.aaa.status.AddStatus.ADD_DATA_SUCCESS;

/**
 * Package: com.aaa.service
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/16 9:43
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
@Service
public class MappingUnitService {
    @Autowired
    private MappingUnitMapper mappingUnitMapper;
    @Autowired
    private FtpProperties ftpProperties;

    private ResourceMapper resourceMapper;



    //查询单位信息
    public MappingUnit selectUnitInfo(MappingUnit mappingUnit){
        return  mappingUnitMapper.selectOne(mappingUnit);
    }


    //修改单位信息
    public int updateUnitInfo(MappingUnit mappingUnit){
        return  mappingUnitMapper.updateByPrimaryKeySelective(mappingUnit);
    }

    //添加测绘成果及档案
    public Map<String,Object> addUnit(MultipartFile file,
                                      MultipartFile file2,
                                      MultipartFile file3,
                                      MultipartFile file4,
                                      Long unitId, UploadService uploadService){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        Boolean result = false;
        if (file != null) {
            //添加资源表
            Resource resource = new Resource();
            //设置资源ID
            String resourceId = FileNameUtils.getFileName();
            //获取日期格式化后的数据，用来当做数据
            String filePath = com.aaa.utils.DateUtils.formatDate(new Date(),"yyyy/MM/dd");
            //获取原始文件的名称
            String oldFilename = file.getOriginalFilename();
            //截取文件后缀
            String exName = oldFilename.substring(oldFilename.lastIndexOf("."));
            //生成新的文件名称
            String newFileName = resourceId + "" + exName;
            //设置resource对象的值
            resource.setName(file.getOriginalFilename()).setSize(Long.valueOf(file.getSize())).setPath(ftpProperties.getHttpPath()+"/"+filePath+"/"+ newFileName)
                    .setType(file.getContentType()).setExtName(exName).setRefBizType("档案主管部门认证认可文件或取得相应考核的文件（概要）").setRefBizId(Long.valueOf(unitId))
                    .setCreateTime(DateUtil.now()).setId(Long.valueOf(resourceId));
            //数据库添加resource的数据
            int r = resourceMapper.insert(resource);
            if (r > 0) {
                    //添加成功后上传文件
                    result = uploadService.uploadFile(file,filePath,newFileName);
            }

        }
        if (null != file2){
            //添加资源表
            Resource resource = new Resource();
            //设置资源ID
            String resourceId = FileNameUtils.getFileName();
            //获取今天日期格式化后的数据，用来当做路径
            String filePath = com.aaa.utils.DateUtils.formatDate(new Date(), "yyyy/MM/dd");
            //获取原始文件的名称
            String oldFilename = file2.getOriginalFilename();
            //截取文件后缀
            String extName = oldFilename.substring(oldFilename.lastIndexOf("."));
            //生成新的文件名称
            String newFileName = resourceId + "" + extName;
            //设置resource对象的值
            resource.setName(file2.getOriginalFilename()).setSize(Long.valueOf(file2.getSize())).setPath(ftpProperties.getHttpPath()+"/"+filePath+"/"+newFileName)
                    .setType(file2.getContentType()).setExtName(extName).setRefBizType("测绘成果及资料档案管理制度（概要）").setRefBizId(Long.valueOf(unitId))
                    .setCreateTime(DateUtil.now()).setId(Long.valueOf(resourceId));
            //数据库添加resource的数据
            int r = resourceMapper.insert(resource);
            if (r > 0){
                //添加成功后上传文件
                result = uploadService.uploadFile(file2, filePath, newFileName);
            }
        }
        if (null != file3){
            //添加资源表
            Resource resource = new Resource();
            //设置资源ID
            String resourceId = FileNameUtils.getFileName();
            //获取今天日期格式化后的数据，用来当做路径
            String filePath = com.aaa.utils.DateUtils.formatDate(new Date(), "yyyy/MM/dd");
            //获取原始文件的名称
            String oldFilename = file3.getOriginalFilename();
            System.out.println(oldFilename);
            //截取文件后缀
            String extName = oldFilename.substring(oldFilename.lastIndexOf("."));
            //生成新的文件名称
            String newFileName = resourceId + "" + extName;
            //设置resource对象的值
            resource.setName(file3.getOriginalFilename()).setSize(Long.valueOf(file3.getSize())).setPath(ftpProperties.getHttpPath()+"/"+filePath+"/"+newFileName)
                    .setType(file3.getContentType()).setExtName(extName).setRefBizType("测绘成果及资料档案管理机构、人员情况（概要）").setRefBizId(Long.valueOf(unitId))
                    .setCreateTime(DateUtil.now()).setId(Long.valueOf(resourceId));
            //数据库添加resource的数据
            int r = resourceMapper.insert(resource);
            if (r > 0){
                //添加成功后上传文件
                result = uploadService.uploadFile(file3, filePath, newFileName);
            }
        }
        if (null != file4){
            //添加资源表
            Resource resource = new Resource();
            //设置资源ID
            String resourceId = FileNameUtils.getFileName();
            //获取今天日期格式化后的数据，用来当做路径
            String filePath = com.aaa.utils.DateUtils.formatDate(new Date(), "yyyy/MM/dd");
            //获取原始文件的名称
            String oldFilename = file4.getOriginalFilename();
            //截取文件后缀
            String extName = oldFilename.substring(oldFilename.lastIndexOf("."));
            //生成新的文件名称
            String newFileName = resourceId + "" + extName;
            //设置resource对象的值
            resource.setName(file4.getOriginalFilename()).setSize(Long.valueOf(file4.getSize())).setPath(ftpProperties.getHttpPath()+"/"+filePath+"/"+newFileName)
                    .setType(file4.getContentType()).setExtName(extName).setRefBizType("测绘成果及资料档案管理设施说明（概要）").setRefBizId(Long.valueOf(unitId))
                    .setCreateTime(DateUtil.now()).setId(Long.valueOf(resourceId));
            //数据库添加resource的数据
            int r = resourceMapper.insert(resource);
            if (r > 0){
                //添加成功后上传文件
                result = uploadService.uploadFile(file4, filePath, newFileName);
            }
        }
        if (result){
            resultMap.put("code",ADD_DATA_SUCCESS.getCode());
            resultMap.put("msg",ADD_DATA_SUCCESS.getMsg());
            return resultMap;
        }
        resultMap.put("code",ADD_DATA_FAILED.getCode());
        resultMap.put("msg",ADD_DATA_FAILED.getMsg());
        return resultMap;
    }

}


