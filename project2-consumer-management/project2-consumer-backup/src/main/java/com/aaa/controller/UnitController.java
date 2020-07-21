package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.Audit;
import com.aaa.model.Score;
import com.aaa.service.MappingApiService;
import com.aaa.vo.UnitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Company: AAA软件教育
 * @Author: Cancer:栗仁杰
 * @Date: Created in 2020/7/18 15:38
 * @Description:
 */
@RestController
@RequestMapping("/mappingUnit")
public class UnitController {
    @Autowired
    private MappingApiService mappingApiService;
    /**
     *@author: Cancer:栗仁杰
     *@description:单位审核--分页查询单位列表
     *@param: []
     *@date: 15:41 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/selectUnit")
    public ResultData selectUnit(@RequestBody UnitVo unitVo){

        return mappingApiService.selectUnit(unitVo);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:
     *           查询单位修改待审核信息
     *@param: []
     *@date: 15:42 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/selectUpdateUnit")
    public ResultData selectUpdateUnit(@RequestBody UnitVo unitVo){
        return mappingApiService.selectUpdateUnit(unitVo);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:
     *             查询单位注册待审核信息
     *@param: []
     *@date: 15:43 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/selectRegistrationUnit")
    public ResultData selectRegistrationUnit(@RequestBody UnitVo unitVo){
        return mappingApiService.selectRegistrationUnit(unitVo);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:
     *         修改单位分值
     *@param: []
     *@date: 15:43 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/updateScore")
    public ResultData updateScore(@RequestBody Score score){

        return mappingApiService.updateScore(score);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:
     *             根据单位id查询分值日志
     *@param: []
     *@date: 15:45 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/selectScore")
    public ResultData selectScore(@RequestParam("unitId") Integer unitId ){
        return mappingApiService.selectScore(unitId);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:
     *      根据单位id查询审核日志
     *@param: []
     *@date: 15:45 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/selectAudit")
    public ResultData selectAudit(@RequestParam("refId") Integer refId ){
        return mappingApiService.selectAudit(refId);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:
     *        审核
     *@param: []
     *@date: 15:46 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/sceneUnit")
    public ResultData sceneUnit(@RequestBody Audit audit){

        return mappingApiService.sceneUnit(audit);
    }



























































}
