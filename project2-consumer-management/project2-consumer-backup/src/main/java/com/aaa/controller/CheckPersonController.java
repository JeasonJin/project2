package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.CheckPerson;
import com.aaa.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Company: AAA软件教育
 * @Author: Cancer:栗仁杰
 * @Date: Created in 2020/7/21 16:02
 * @Description:
 *        双随机抽查---》抽查人员
 */
@RestController
@RequestMapping("/checkPerson")
@Api(value = "抽查人员",tags = "抽查人员接口")
public class CheckPersonController extends BaseController {
    @Autowired
    IProjectService iProjectService;
    /**
     *@author: Cancer:栗仁杰
     *@description:查询所有抽查人员
     *@param: []
     *@date: 16:08 2020/7/21
     *@return:
     *@throws:
     **/
    @GetMapping("/selectAllCheckPerson")
    @ApiOperation(value = "根据条件抽查人员",notes = "查询抽查人员")
    public ResultData selectAllCheckPerson (@RequestBody HashMap map){
        return iProjectService.selectAllCheckPerson(map);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:添加抽查人员
     *@param: []
     *@date: 16:46 2020/7/21
     *@return:
     *@throws:
     **/
    @GetMapping("/addCheckPerson")
    @ApiOperation(value = "根据条件添加抽查人员",notes = "添加抽查人员")
    public ResultData addCheckPerson(@RequestBody CheckPerson checkPerson){
        return iProjectService.addCheckPerson(checkPerson);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:修改抽查人员
     *@param: []
     *@date: 16:53 2020/7/21
     *@return:
     *@throws:
     **/
    @GetMapping("/updateCheckPerson")
    @ApiOperation(value = "根据条件修改抽查人员",notes = "修改抽查人员")
    public ResultData updateCheckPerson(@RequestBody CheckPerson checkPerson){
        return iProjectService.updateCheckPerson(checkPerson);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:删除抽查人员
     *@param: []
     *@date: 16:58 2020/7/21
     *@return:
     *@throws:
     **/
    @GetMapping("/ delCheckPerson")
    @ApiOperation(value = "根据条件删除抽查人员",notes = "删除抽查人员")
    public ResultData delCheckPerson(@RequestBody List<Long> ids){
        return iProjectService.delCheckPerson(ids);
    }
}
