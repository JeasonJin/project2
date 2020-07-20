package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.IProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.aaa.controller
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/17 11:42
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
@RestController
public class MappingProjectController  extends BaseController {
    @Autowired
    private IProjectService iProjectService;
    /**
     * @Author yao
     * @Description ////测绘项目管理，项目名称模糊查询，类型 ，日期精确查寻
     * @Date 2020/7/17
     * @Param
     * @return
     **/
    @PostMapping("/projectSelect")
    @ApiOperation(value = "根据查询条件查询测绘项目",notes = "首页查询")
    public ResultData projectSelect(@RequestParam MappingProject mappingProject){
        return  iProjectService.projectSelect(mappingProject);
    }
    /**
     * @Author yao
     * @Description //通过字段查询所有项目的类型和开工日期、分组
     * @Date 2020/7/17
     * @Param
     * @return
     **/
    @PostMapping("/selectName")
    public ResultData selectName(@RequestParam MappingProject mappingProject){
        return  iProjectService.selectName(mappingProject);
    }
    /**
     * @Author yao
     * @Description //通过id查询项目
     * @Date 2020/7/17
     * @Param
     * @return
     **/
    @PostMapping("/projectDetail")
    public ResultData projectDetail(@RequestParam MappingProject mappingProject){
        return  iProjectService.projectDetail(mappingProject);
    }




}
