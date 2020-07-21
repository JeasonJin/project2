package com.aaa.mapper;

import com.aaa.model.CheckPerson;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Company: AAA软件教育
 * @Author: Cancer:栗仁杰
 * @Date: Created in 2020/7/16 10:55
 * @Description:
 */
public interface CheckPersonMapper extends Mapper<CheckPerson> {
    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);
    /**
     * 添加
     * @param checkPerson
     * @return
     */
    int insert(CheckPerson checkPerson);
    /**
     * 根据主键查询
     * @param id
     * @return
     */
    CheckPerson selectByPrimaryKey(Long id);
    /**
     * 查询全部
     * @param hashMap
     * @return
     */
    List<CheckPerson> selectAll(HashMap hashMap);
    /**
     * 修改
     * @param checkPerson
     * @return
     */
    int updateByPrimaryKey(CheckPerson checkPerson);

}
