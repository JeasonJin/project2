package com.aaa.mapper;

import com.aaa.model.News;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface NewsMapper extends Mapper<News> {
    /**
     * @Author yao
     * @Description 分页查询所有新闻公告
     * @Date 2020/7/22
     * @Param
     * @return
     **/
    List<HashMap>selectNewsAll(HashMap map);
}