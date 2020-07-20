package com.aaa.mapper;

import com.aaa.model.Dept;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.HashMap;
import java.util.List;

public interface DeptMapper extends BaseMapper<Dept> {
   List<Dept> selectDeptByNameOrTime(HashMap map);
}