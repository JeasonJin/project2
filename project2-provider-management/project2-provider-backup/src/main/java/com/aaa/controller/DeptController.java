package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Dept;
import com.aaa.redis.RedisService;
import com.aaa.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.status.LoginStatus.LOGIN_TIMEOUT_EXIT;
import static com.aaa.status.OperationStatus.SUCCESS;
import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * @ClassName DeptController
 * @Description TODO
 * @Author jyz
 * @date 2020/7/16 11:25
 **/
@RestController
@Slf4j
public class DeptController extends CommonController<Dept> {
    @Autowired
    private DeptService deptService;

    @Autowired
    private RedisService redisService;
    @Override
    public BaseService<Dept> getBaseService(){
        return deptService;
    }

    /**
     * @Author jyz
     * @Description //TODO 查询部门信息
     * @Date 10:31 2020/7/17
     * @Param [map]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllDept")
    public ResultData selectAllDept(@RequestBody HashMap map){
        Map<String , Object> resultMap = deptService.selectAllDept(map);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
        }else if (LOGIN_TIMEOUT_EXIT.getCode().equals(resultMap.get("code"))){
            return super.loginTimeoutExit();
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 添加部门信息
     * @Date 10:45 2020/7/17
     * @Param [dept]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/addDept")
    public ResultData addDept(@RequestBody Dept dept){
        Map<String , Object> addResult = deptService.addDept(dept);
        if (SUCCESS.getCode().equals(addResult.get("code"))){
            return super.operationSuccess();
        }else if (LOGIN_TIMEOUT_EXIT.getCode().equals(addResult.get("code"))){
            return super.loginTimeoutExit();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 更改操作
     * @Date 11:00 2020/7/17
     * @Param [dept]
     * @return com.aaa.base.ResultData
     **/
    public ResultData updateDept(@RequestBody Dept dept) {
        System.out.println(dept);
        Map<String, Object> updateResult = deptService.updateDept(dept);
        if (SUCCESS.getCode().equals(updateResult.get("code"))) {
            return super.operationSuccess();
        }else if (LOGIN_TIMEOUT_EXIT.getCode().equals(updateResult.get("code"))){
            return super.loginTimeoutExit();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 批量删除部门信息
     * @Date 10:56 2020/7/17
     * @Param [ids]
     * @return com.aaa.base.ResultData
     **/
    @DeleteMapping("/delDept")
    public ResultData delDept (@RequestBody List<Long> ids){
        Map<String , Object> resultMap = deptService.delDept(ids);
        if (SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.operationSuccess();
        }else if (LOGIN_TIMEOUT_EXIT.getCode().equals(resultMap.get("code"))){
            return super.loginTimeoutExit();
        }else {
            return super.operationFailed();
        }
    }
}
