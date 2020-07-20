package com.aaa.mapper;

import com.aaa.model.ResultCommit;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface ResultCommitMapper extends Mapper<ResultCommit> {
    /**
     * @Author yao
     * @Description 查询所有测绘成果
     * @Date 2020/7/17
     * @Param
     * @return
     **/
    List<HashMap> selectAllResultCommit();

    /**
     * @Author yao
     * @Description 根据条件查询测绘成果
     * @Date 2020/7/17
     * @Param
     * @return
     **/
    List<HashMap>selectResultByFeild(HashMap hashMap);
    /**
     * @Author yao
     * @Description 查询所有测绘类型
     * @Date 2020/7/17
     * @Param
     * @return
     **/
    List<HashMap>selectMapType();
    /**
     * @Author yao
     * @Description 查询详细测绘信息
     * @Date 2020/7/17
     * @Param
     * @return
     **/

    List<HashMap> resultDetail(String id);
}