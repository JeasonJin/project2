package com.aaa.service;


import cn.hutool.core.date.DateUtil;
import com.aaa.mapper.MappingProjectMapper;
import com.aaa.model.MappingProject;
import com.aaa.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.status.AddStatus.ADD_DATA_FAILED;
import static com.aaa.status.AddStatus.ADD_DATA_SUCCESS;
import static com.aaa.status.SelectStatus.*;

/**
 * Package: com.aaa.service
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/16 10:35
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
//项目管理
@Service
public class MappingProjectService {
@Autowired
private MappingProjectMapper mappingProjectMapper;

    //测绘项目管理，项目名称模糊查询，类型 ，日期精确查询
    public Map<String,Object> projectSelect(MappingProject mappingProject) {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        List<HashMap> restdata = new ArrayList<HashMap>();
        if (null ==  mappingProject) {
            restdata = mappingProjectMapper.selectAllProject();
        }else {
            restdata = mappingProjectMapper.projectSelect(mappingProject);
        }
        if (restdata.size() > 0) {
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",restdata);
        }else {
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
        }
        return  resultMap;
    }

    //通过字段查询所有项目
    public Map<String,Object>selectName(String name){
        HashMap<String,Object> resultMap = new HashMap<String, Object>();
        List<HashMap> restdata = new ArrayList<HashMap>();
        restdata = mappingProjectMapper.selectName(name);
        if (restdata.size()>0) {
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",restdata);
        }else {
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_FAILED.getMsg());
        }
        return  resultMap;
    }
    //通过ID查询项目
    public  HashMap<String,Object>projectDetail(String id){
        HashMap<String,Object>resultMap = new HashMap<String, Object>();
        if (null !=id&& !("").equals(id)) {
        List<HashMap> restdata = mappingProjectMapper.projectDetail(id);
            if (restdata.size() ==1) {
                resultMap.put("code",SELECT_DATA_BY_ID_SUCCESS.getCode());
                resultMap.put("msg",SELECT_DATA_BY_ID_SUCCESS.getMsg());
                resultMap.put("data",restdata);
                return  resultMap;
            }
        }
        resultMap.put("code",SELECT_DATA_BY_ID_FAILED.getCode());
        resultMap.put("msg",SELECT_DATA_BY_ID_FAILED.getMsg());
        return resultMap;
    }
    /**
     * @Author yao
     * @Description 通过id修改项目
     * @Date 2020/7/19
     * @Param
     * @return
     **/
    public Integer updateById(MappingProject mappingProject){
        System.out.println(mappingProject);
        int i = 0;
        try {
            if (!"".equals(mappingProject)){
                //执行修改的方法 返回受影响的行数
                i = mappingProjectMapper.updateByPrimaryKeySelective(mappingProject);
                //判断受影响的行数
                if (i>0){
                    return i;
                }else {
                    //再次执行修改操作
                    int j = mappingProjectMapper.updateByPrimaryKeySelective(mappingProject);
                    if (j>0){
                        return j;
                    }
                }
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author yao
     * @Description 新增项目
     * @Date 2020/7/21
     * @Param
     * @return
     **/
    public Map<String,Object>addProject(MappingProject mappingProject){
        Map<String,Object>resultMap = new HashMap<String, Object>();
        mappingProject.setCreateTime(DateUtil.now());
        int addResult = mappingProjectMapper.insert(mappingProject);
        if (addResult > 0) {
            resultMap.put("code",ADD_DATA_SUCCESS.getCode());
            resultMap.put("msg",ADD_DATA_SUCCESS.getMsg());
        }else{
            resultMap.put("code",ADD_DATA_FAILED.getCode());
            resultMap.put("msg",ADD_DATA_FAILED.getMsg());
        }
        return  resultMap;
    }

}
