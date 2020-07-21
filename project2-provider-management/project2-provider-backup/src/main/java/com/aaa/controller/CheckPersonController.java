package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.CheckPerson;
import com.aaa.service.CheckPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.script.ScriptTemplateConfig;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.status.AddStatus.ADD_DATA_SUCCESS;
import static com.aaa.status.DeleteStatus.DELETE_DATA_SUCCESS;
import static com.aaa.status.LoginStatus.LOGIN_TIMEOUT_EXIT;
import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;
import static com.aaa.status.UpdateStatus.UPDATE_DATA_SUCCESS;

/**
 * @Company: AAA软件教育
 * @Author: Cancer:栗仁杰
 * @Date: Created in 2020/7/16 18:40
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/checkPerson")
public class CheckPersonController extends CommonController<CheckPerson> {
@Autowired
private CheckPersonService checkPersonService;
    /**
     *@author: Cancer:栗仁杰
     *@description:查询
     *@param: []
     *@date: 10:23 2020/7/20
     *@return:
     *@throws:
     **/
    @PostMapping("/selectAllCheckPerson")
    ResultData selectAllCheckPerson(@RequestBody HashMap map){
        Map<String,Object> resultMap = checkPersonService.selectAllCheckPerson(map);
        if(SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.selectSuccess(resultMap.get("data"));
        }else if (LOGIN_TIMEOUT_EXIT.getCode().equals(resultMap.get("code"))){
            return super.loginTimeoutExit();
        }else{
            return super.selectFailed();
        }


    }
    /**
     *@author: Cancer:栗仁杰
     *@description:新增抽查人员
     *@param: []
     *@date: 15:43 2020/7/21
     *@return:
     *@throws:
     **/
     @PostMapping("/addCheckPerson")
     ResultData addCheckPerson (@RequestBody CheckPerson checkPerson){
         Map<String,Object> addResult = checkPersonService.addCheckPerson(checkPerson);
         if (ADD_DATA_SUCCESS.getCode().equals(addResult.get("code"))){
             return super.addFailed();
         }else if (LOGIN_TIMEOUT_EXIT.getCode().equals(addResult.get("code"))){
             return super.loginTimeoutExit();
         }else {
             return super.addFailed();
         }

     }
    /**
     *@author: Cancer:栗仁杰
     *@description:修改新增人员
     *@param: []
     *@date:  2020/7/21
     *@return: com.aaa.base.ResultData
     *@throws:
     **/
    @PostMapping("/updateCheckPerson")
    ResultData updateCheckPerson(@RequestBody CheckPerson checkPerson){
        System.out.println(checkPerson);
        Map<String,Object> updateResult = checkPersonService.updateCheckPerson(checkPerson);
        if (UPDATE_DATA_SUCCESS.getCode().equals(updateResult.get("code"))){
            return super.updateSuccess();
        }else if (LOGIN_TIMEOUT_EXIT.getCode().equals(updateResult.get("code"))){
            return super.loginTimeoutExit();
        }else{
            return super.updateFailed();
        }
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:删除抽查人员
     *@param: []
     *@date: 20:49 2020/7/20
     *@return: com.aaa.base.ResultData
     *@throws:
     **/
    @DeleteMapping("/delCheckPerson")
    public ResultData delCheckPerson(@RequestBody List<Long> ids)
    {
        System.out.println("-----------------这里是删除方法---------------");
        System.out.println("id"+ids);
        HashMap<String,Object> delCheckPersonResult = checkPersonService.delCheckPerson(ids);
        Object code = delCheckPersonResult.get("code");
        if (DELETE_DATA_SUCCESS.getCode().equals(code)){
            return super.deleteSuccess();
        }else {
            return super.deleteFailed();
        }
    }












    @Override
    public BaseService<CheckPerson> getBaseService() {
        return null;
    }
}
