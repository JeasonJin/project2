package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.DeptMapper;
import com.aaa.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.status.OperationStatus.*;
import static com.aaa.status.SelectStatus.SELECT_DATA_FAILED;
import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * @ClassName DeptService
 * @Description TODO
 * @Author jyz
 * @date 2020/7/16 11:21
 **/
@Service
public class DeptService extends BaseService<Dept> {
    @Autowired
    private DeptMapper deptMapper;
    /**
     * @Author jyz
     * @Description //TODO 通过条件查询部门信息
     * @Date 9:34 2020/7/17
     * @Param [hashMap]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    public Map<String,Object> selectAllDept(HashMap hashMap){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<Dept> depts = deptMapper.selectDeptByNameOrTime(hashMap);
        if (depts.size() > 0 && depts != null){
            resultMap.put("code",SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data",depts);
        }else {
            resultMap.put("code",SELECT_DATA_FAILED.getCode());
            resultMap.put("msg",SELECT_DATA_SUCCESS.getMsg());
        }
        return resultMap;
    }

    /**
     * @Author jyz
     * @Description //TODO 添加部门信息
     * @Date 9:56 2020/7/17
     * @Param [dept]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    public Map<String,Object> addDept(Dept dept){
        Map<String , Object> resultMap = new HashMap<String, Object>();
        Date date = new Date();
        dept.setCreateTime(date);
        int addResult = deptMapper.insert(dept);
        if (addResult > 0){
            resultMap.put("code",SUCCESS.getCode());
            resultMap.put("msg",SUCCESS.getMsg());
        }else {
            resultMap.put("code",FAILED.getCode());
            resultMap.put("msg",FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @Author jyz
     * @Description //TODO 修改部门信息
     * @Date 10:05 2020/7/17
     * @Param [dept]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    public Map<String, Object> updateDept(Dept dept){
        Map<String , Object> resultMap = new HashMap<String, Object>();
        Date date = new Date();
        dept.setModifyTime(date);
        Dept dept1 = deptMapper.selectByPrimaryKey(dept);
        if (dept1 != null || !"".equals(dept1)){
            Date createTime = dept1.getCreateTime();
            dept.setCreateTime(createTime);
        }
        int updateResult = deptMapper.updateByPrimaryKey(dept);
        if (updateResult > 0 ){
            resultMap.put("code",SUCCESS.getCode());
            resultMap.put("msg",SUCCESS.getMsg());
        }else {
            resultMap.put("code" , FAILED.getCode());
            resultMap.put("msg", FAILED.getMsg());
        }
        return resultMap;
    }

    public Map<String ,Object> delDept(List<Long> ids){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        Example example = Example.builder(Dept.class).where(Sqls.custom().andIn("deptid", ids)).build();
        int i = deptMapper.deleteByPrimaryKey(example);
        if (i > 0){
            resultMap.put("code",DELETE_OPERATION.getCode());
            resultMap.put("msg",DELETE_OPERATION.getMsg());
        }else {
            resultMap.put("code",FAILED.getCode());
            resultMap.put("msg",FAILED.getMsg());
        }
        return resultMap;
    }
}
