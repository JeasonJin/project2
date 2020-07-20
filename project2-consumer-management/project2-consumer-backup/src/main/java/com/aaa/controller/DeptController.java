package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Dept;
import com.aaa.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName DeptController
 * @Description TODO
 * @Author jyz
 * @date 2020/7/17 11:16
 **/
@RestController
@Api(value = "部门管理" ,tags = "部门管理接口")
public class DeptController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @Author jyz
     * @Description //TODO 查询部门信息
     * @Date 11:18 2020/7/17
     * @Param [map]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllDept")
    @ApiOperation(value = "根据条件查询部门",notes = "部门管理的查询")
    public ResultData selectAllDept(@RequestBody HashMap map){
        return iProjectService.selectAllDept(map);
    }

    /**
     * @Author jyz
     * @Description //TODO 添加部门
     * @Date 11:18 2020/7/17
     * @Param [dept]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/addDept")
    @ApiOperation(value = "根据条件添加部门",notes = "部门管理的添加")
    public ResultData addDept(@RequestBody Dept dept){
        return iProjectService.addDept(dept);
    }

    /**
     * @Author jyz
     * @Description //TODO 修改部门
     * @Date 11:19 2020/7/17
     * @Param [dept]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/updateDept")
    @ApiOperation(value = "根据条件修改部门",notes = "部门管理的修改")
    public ResultData updateDept(@RequestBody Dept dept){
        return iProjectService.updateDept(dept);
    }

    /**
     * @Author jyz
     * @Description //TODO 删除部门
     * @Date 11:20 2020/7/17
     * @Param [ids]
     * @return com.aaa.base.ResultData
     **/
    @DeleteMapping("/delDept")
    @ApiOperation(value = "删除部门",notes = "部门管理的批量删除")
    public ResultData delDept(@RequestBody List<Long> ids){
        return iProjectService.delDept(ids);
    }
}
