package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.IProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Package: com.aaa.controller
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/18 11:24
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
@RestController
public class ResultCommitController  {
    @Autowired
    private IProjectService iProjectService;
    /**
     * @Author yao
     * @Description 查询所有测绘成果
     * @Date 2020/7/18
     * @Param
     * @return
     **/
    @PostMapping("/selectAllResultCommit")
    @ApiOperation(value = "查询全部测绘成果" ,notes ="查询测绘成果" )
    public ResultData selectAllResultCommit (@RequestBody HashMap hashMap){
        return  iProjectService.selectAllResultCommit(hashMap);
    }
    /**
     * @Author yao
     * @Description 查询所有的测绘类型
     * @Date 2020/7/18
     * @Param
     * @return
     **/
    @PostMapping("/SelectMapType")
    @ApiOperation(value = "查询测绘所有类型",notes = "查询测绘类型")
    public ResultData SelectMapType(){
        return iProjectService.selectMapType();
    }
    /**
     * @Author yao
     * @Description 查询出成果的详细信息
     * @Date 2020/7/18
     * @Param
     * @return
     **/
    @PostMapping("/resultDetail")
    @ApiOperation(value = "查询测绘成果的所有信息",notes = "通过id查询信息")
    public ResultData resultDetail(@RequestParam("id") String id){
        System.out.println(id);
        return iProjectService.resultDetail(id);
    }
}
