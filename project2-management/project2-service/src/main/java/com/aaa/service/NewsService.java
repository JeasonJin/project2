package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.NewsMapper;
import com.aaa.model.News;
import com.aaa.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.status.SelectStatus.*;

/**
 * Package: com.aaa.service
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/22 9:38
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
@Service
public class NewsService extends BaseService<News> {
    @Autowired
    private NewsMapper newsMapper;
            //查询所有新闻公告
    public Map<String,Object>selectNewsAll(HashMap map){
        Map<String,Object>resultMap = new HashMap<String, Object>();
        List<HashMap>news = newsMapper.selectNewsAll(map);
        if (null !=news && news.isEmpty()){
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",news);
            return  resultMap;
        }else {
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("code",SELECT_DATA_FAILED.getMsg());
        }
        return  resultMap;
    }

}
