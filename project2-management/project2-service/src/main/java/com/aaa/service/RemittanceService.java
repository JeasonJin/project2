package com.aaa.service;

import com.aaa.mapper.MappingProjectMapper;
import com.aaa.model.MappingProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.status.SelectStatus.SELECT_DATA_FAILED;
import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * Package: com.aaa.service
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/23 21:32
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
//项目汇交
@Service
public class RemittanceService {
    @Autowired
    private MappingProjectMapper mappingProjectMapper;
    /**
     * @Author yao
     * @Description 查询所有已提交项目信息
     * @Date 2020/7/23
     * @Param
     * @return
     **/
    public List<HashMap>selectAllProject(){
        List<HashMap> projectList = null;
        try{
            projectList = mappingProjectMapper.selectAllProject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null !=projectList && projectList.size() > 0) {
            return  projectList;
        }else {
            return  null;
        }
    }
        /**
         * @Author yao
         * @Description 根据项目类型进行查询
         * @Date 2020/7/23
         * @Param
         * @return
         **/
        public Map<String,Object> selectName(String name){
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
}
