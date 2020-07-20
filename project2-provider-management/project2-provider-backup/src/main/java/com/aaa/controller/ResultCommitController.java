package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.service.ResultCommitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * Package: com.aaa.controller
 * Description： TODO
 * Author: yao
 * Date: Created in 2020/7/18 10:28
 * Copyright: Copyright (c) 2017
 * Version: 0.0.1
 */
public class ResultCommitController extends CommonController {

    private ResultCommitService resultCommitService;

    /**
     * @Author yao
     * @Description 查询所有测绘成果
     * @Date 2020/7/18
     * @Param
     * @return
     **/
    @PostMapping("/selectAllResultCommit")
    public ResultData selectAllResultCommit(@RequestBody HashMap hashMap){
        System.out.println(hashMap);
        Map<String,Object> resultMap= new HashMap<String, Object>();
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.selectSuccess(resultMap.get("data"));
        }else{
            return super.selectFailed();
        }
    }
    /**
     * @Author yao
     * @Description 查询数据中所有的测绘类型
     * @Date 2020/7/18
     * @Param
     * @return
     **/
    @PostMapping("/selectMapType")
    public ResultData selectMapType(){
        Map<String,Object> resultMap = resultCommitService.selectMapType();
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return  super.selectSuccess(resultMap.get("data"));
        }else{
            return  super.selectFailed();
        }
    }
    /**
     * @Author yao
     * @Description 查询成果的详细信息
     * @Date 2020/7/18
     * @Param
     * @return
     **/
    @PostMapping("/resultDetail")
    public ResultData resultDetail(@RequestParam("id") String id){
        Map<String,Object> resultMap = resultCommitService.resultDetail(id);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return  super.selectSuccess(resultMap.get("data"));
        }else{
            return  super.selectFailed();
        }
    }

    @Override
    public BaseService getBaseService() {
        return null;
    }

}
