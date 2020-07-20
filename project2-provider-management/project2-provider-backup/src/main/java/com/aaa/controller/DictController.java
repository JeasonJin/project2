package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Dict;
import com.aaa.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

import static com.aaa.status.OperationStatus.SUCCESS;
import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * @ClassName DictController
 * @Description TODO
 * @Author jyz
 * @date 2020/7/17 18:36
 **/
@RestController
@Slf4j
public class DictController extends CommonController<Dict> {
    @Autowired
    private DictService dictService;

    @Override
    public BaseService<Dict> getBaseService(){
        return dictService;
    }

    /**
     * @Author jyz
     * @Description //TODO 分页查询
     * @Date 19:59 2020/7/17
     * @Param [hashMap]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllDictByPage")
    public ResultData selectAllDictByPage(@RequestBody HashMap hashMap) throws Exception {
        HashMap<String,Object> resultMap =  dictService.selectAllDictByPage(hashMap);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 新增字典信息
     * @Date 20:00 2020/7/17
     * @Param [dict]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/addDict")
    public ResultData addDict(@RequestBody Dict dict){
        HashMap<String,Object> addDictResult = dictService.addDict(dict);
        if (SUCCESS.getCode().equals(addDictResult.get("code"))){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 批量删除字典
     * @Date 20:05 2020/7/17
     * @Param [ids]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/delDictsById")
    public ResultData delDictsById(@RequestBody List<Long> ids){
        HashMap<String,Object> delDictResult = dictService.delDictsById(ids);
        if (SUCCESS.getCode().equals(delDictResult.get("code"))){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 更改字典信息
     * @Date 20:08 2020/7/17
     * @Param [dict]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/updateDict")
    public ResultData updateDict(@RequestBody Dict dict){
        HashMap<String,Object> updateDictResult = dictService.updateDict(dict);
        if (SUCCESS.getCode().equals(updateDictResult.get("code"))){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }
}
