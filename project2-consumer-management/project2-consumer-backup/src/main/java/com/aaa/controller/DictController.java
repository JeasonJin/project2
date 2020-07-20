package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Dict;
import com.aaa.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName DictController
 * @Description TODO
 * @Author jyz
 * @date 2020/7/17 20:21
 **/
@RestController
@Api(value = "字典管理" ,tags = "字典管理管理接口")
public class DictController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @Author jyz
     * @Description //TODO 查询字典信息
     * @Date 20:26 2020/7/17
     * @Param [hashMap]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllDictByPage")
    @ApiOperation(value = "分页查询字典信息",notes = "字典管理的查询")
    public ResultData selectAllDictByPage(@RequestBody HashMap hashMap) throws Exception {
        return iProjectService.selectAllDictByPage(hashMap);
    }

    /**
     * @Author jyz
     * @Description //TODO 增加字典信息
     * @Date 20:28 2020/7/17
     * @Param [dict]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/addDict")
    @ApiOperation(value = "增加字典信息",notes = "字典管理的增加")
    public ResultData addDict(@RequestBody Dict dict) {
        return iProjectService.addDict(dict);
    }

    /**
     * @Author jyz
     * @Description //TODO 删除字典信息
     * @Date 20:29 2020/7/17
     * @Param [ids]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/delDictsById")
    @ApiOperation(value = "批量删除字典信息",notes = "字典管理的删除")
    public ResultData delDictsById(@RequestBody List<Long> ids){
        return iProjectService.delDictsById(ids);
    }

     /**
      * @Author jyz
      * @Description //TODO 修改字典信息
      * @Date 20:31 2020/7/17
      * @Param [dict]
      * @return com.aaa.base.ResultData
      **/
    @PostMapping("/updateDict")
    @ApiOperation(value = "修改字典信息",notes = "字典管理的修改")
    public ResultData updateDict(@RequestBody Dict dict){
        return iProjectService.updateDict(dict);
    }

}
