package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Package: com.aaa.controller
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/17 11:42
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
@RestController
@Api(value = "项目管理", tags = "项目管理接口")
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
    public ResultData projectSelect(@RequestBody MappingProject mappingProject){
        return  iProjectService.projectSelect(mappingProject);
    }

    /**
     * @Author yao
     * @Description //通过id查询项目
     * @Date 2020/7/17
     * @Param
     * @return
     **/
    @PostMapping("/projectDetail")
    @ApiOperation(value = "通过id查询测绘工程的详细信息",notes = "首页的工程详情查询")
    public ResultData projectDetail(@RequestParam("id") MappingProject mappingProject){
        return  iProjectService.projectDetail(mappingProject);
    }
    /**2
     * @Author yao
     * @Description 通过id修改项目
     * @Date 2020/7/19
     * @Param
     * @return
     **/
    @PostMapping("/updateById")
    @ApiOperation(value = "修改项目",notes = "项目管理的修改项目")
    public ResultData updateById(@RequestBody MappingProject mappingProject){
        Integer i = iProjectService.updateById(mappingProject);
        if (null != i && i > 0){
            return super.updateSuccess();
        }
        return super.updateFailed();
    }
    /**
     * @Author yao
     * @Description 项目添加
     * @Date 2020/7/21
     * @Param
     * @return
     **/
    @PostMapping("/addProject")
    @ApiOperation(value = "添加项目",notes = "项目管理的新增项目")
    public  ResultData addProject(@RequestBody MappingProject mappingProject){
        return  iProjectService.addProject(mappingProject);
    }





}
