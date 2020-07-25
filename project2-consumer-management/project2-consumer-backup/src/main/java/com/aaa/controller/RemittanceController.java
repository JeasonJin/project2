package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.aaa.controller
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/23 22:11
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
@RestController
@Api(value = "项目汇交", tags = "项目汇交接口")
public class RemittanceController extends BaseController {
    @Autowired
    private IProjectService iProjectService;
    /**
     * @Author yao
     * @Description //通过项目类型查询所有项目
     * @Date 2020/7/23
     * @Param
     * @return
     **/
    @PostMapping("/selectName")
    @ApiOperation(value = "根据项目类型进行查询",notes = "根据项目类型进行查询")
    public ResultData selectName(@RequestParam("name") MappingProject mappingProject){
        return  iProjectService.selectName(mappingProject);
    }
}
