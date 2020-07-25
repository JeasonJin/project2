package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.News;
import com.aaa.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.aaa.controller
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/22 11:33
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
@RestController
@Api(value = "公告栏" ,tags = "公告栏接口")
public class NewsController extends BaseController {
    @Autowired
    private IProjectService iProjectService;
    /**
     * @Author yao
     * @Description 查询所有新闻公告
     * @Date 2020/7/22
     * @Param
     * @return
     **/
    @PostMapping("/selectNewsAll")
    @ApiOperation(value = "查询公告" , notes = "查询所有公告")
    public ResultData selectNewsAll(@RequestBody News news){
        return  iProjectService.selectNewsAll(news);
    }


}
