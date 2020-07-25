package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.mapper.MappingProjectMapper;
import com.aaa.model.MappingProject;
import com.aaa.service.RemittanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.aaa.status.SelectStatus.SELECT_DATA_BY_ID_SUCCESS;

/**
 * Package: com.aaa.controller
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/23 21:00
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
//项目汇交
@RestController
public class RemittanceController extends CommonController<MappingProject> {
    @Autowired
    private RemittanceService remittanceService;
    /**
     * @Author yao
     * @Description 根据项目类型查询
     * @Date 2020/7/23
     * @Param
     * @return
     **/
    @PostMapping("/selectName")
    public ResultData selectName(@RequestParam("name") String name){
        System.out.println(name);
        Map<String,Object> resultMap =remittanceService .selectName(name);
        if (SELECT_DATA_BY_ID_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return  super.selectSuccess(resultMap);
        }else{
            return  super.selectFailed();
        }
    }

    @Override
    public BaseService<MappingProject> getBaseService() {
        return null;
    }
}
