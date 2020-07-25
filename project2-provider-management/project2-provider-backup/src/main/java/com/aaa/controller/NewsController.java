package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.News;
import com.aaa.redis.RedisService;
import com.aaa.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.aaa.status.SelectStatus.*;

/**
 * Package: com.aaa.controller
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/22 9:51
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
@RestController
public class NewsController extends CommonController<News> {
    @Autowired
    private NewsService newsService;
    @Autowired
    private RedisService redisService;

    /**
     * @Author yao
     * @Description 查询全部新闻公告
     * @Date 2020/7/22
     * @Param
     * @return
     **/
    @PostMapping("/selectNewsAll")
    public ResultData selectNewsAll(@RequestBody HashMap map){
        Map<String,Object>resultMap = newsService.selectNewsAll(map);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.selectSuccess(resultMap.get("data"));
    }else{
            return  super.selectFailed();
        }
    }

    @Override
    public BaseService<News> getBaseService() {
        return null;
    }
}
