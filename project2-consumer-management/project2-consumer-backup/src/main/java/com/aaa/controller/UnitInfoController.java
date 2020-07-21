package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.model.Technicist;
import com.aaa.service.MappingApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Company: AAA软件教育
 * @Author: Cancer:栗仁杰
 * @Date: Created in 2020/7/18 10:54
 * @Description:
 *          单位基本信息下的全部模块
 */
@RestController
@RequestMapping("/unit")
public class UnitInfoController {
    @Autowired
    private MappingApiService mappingApiService;
    /**
     *@author: Cancer:栗仁杰
     *@description:查询单位基本信息
     *@param: []
     *@date: 15:32 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/selectUnitInfo")
    public ResultData selectUnitInfo(@RequestParam("userId") String userId){
        return mappingApiService.selectUnitInfo(userId);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:修改单位信息
     *@param: []
     *@date: 15:33 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/updateUnitInfo")
    public ResultData updateUnitInfo(@RequestBody MappingUnit mappingUnit){
        return mappingApiService.updateUnitInfo(mappingUnit);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:查询全部的单位负责人信息
     *@param: []
     *@date: 15:33 2020/7/18
     *@return:
     *@throws:
     **/
    @GetMapping("/selectAllPrincipal")
    public ResultData selectAllPrincipal(@RequestParam("userId") String userId){
        return mappingApiService.selectAllPrincipal(userId);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:查询全部的单位技术员信息
     *@param: []
     *@date: 15:34 2020/7/18
     *@return:
     *@throws:
     **/
    @GetMapping("/selectAllTechnicist")
    public ResultData selectAllTechnicist(@RequestParam("userId") String userId){
        return mappingApiService.selectAllTechnicist(userId);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:添加单位负责人
     *@param: []
     *@date: 15:34 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/addPrincipal")
    public ResultData addPrincipal(@RequestParam("files") MultipartFile[] files, @RequestParam("type") String type, @RequestParam("name") String name, @RequestParam("idType") String idType,
                                   @RequestParam("idNumber") String idNumber, @RequestParam("age") Integer age, @RequestParam("sex") Integer sex,
                                   @RequestParam("workYear") Integer workYear, @RequestParam("duty") String duty, @RequestParam("title") String title,
                                   @RequestParam("major") String major, @RequestParam("mappingYear") Integer mappingYear, @RequestParam("userId") Long userId){
        return mappingApiService.addPrincipal(files,type,name,idType,idNumber,age,sex,workYear,duty,title,major,mappingYear,userId);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:查询单个负责人的信息
     *@param: []
     *@date: 15:35 2020/7/18
     *@return:
     *@throws:
     **/
    @GetMapping("/selectPrincipalById")
    public ResultData selectPrincipalById(@RequestParam("id") String id){
        return mappingApiService.selectPrincipalById(id);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:删除单个负责人的信息
     *@param: []
     *@date: 15:35 2020/7/18
     *@return:
     *@throws:
     **/
    @DeleteMapping("/deletePrincipalById")
    public ResultData deletePrincipalById(@RequestParam("id") String id){
        return mappingApiService.deletePrincipalById(id);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:添加测绘成果及档案管理
     *@param: []
     *@date: 15:35 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/addRecord")
    public ResultData addRecord(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2
            , @RequestParam("file3") MultipartFile file3, @RequestParam("file4") MultipartFile file4, @RequestParam("unitId") Long unitId){
        return mappingApiService.addRecord(file1,file2,file3,file4,unitId);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:添加技术人员信息
     *@param: []
     *@date: 15:36 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/addTechnicist")
    public ResultData addTechnicist(@RequestParam("files") MultipartFile[] files, @RequestParam("majorType") String majorType, @RequestParam("name") String name, @RequestParam("idType") String idType,
                                    @RequestParam("idNumber") String idNumber, @RequestParam("age") Integer age, @RequestParam("sex") Integer sex,
                                    @RequestParam("workYear") Integer workYear, @RequestParam("duty") String duty, @RequestParam("title") String title,
                                    @RequestParam("school") String school, @RequestParam("graduationDate") String graduationDate, @RequestParam("degree") String degree,
                                    @RequestParam("educationBackground") String educationBackground, @RequestParam("major") String major,
                                    @RequestParam("titleMajor") String titleMajor, @RequestParam("startTime") String startTime, @RequestParam("titleTime") String titleTime,
                                    @RequestParam("startContract") String startContract, @RequestParam("endContract") String endContract, @RequestParam("post") String post,
                                    @RequestParam("mappingYear") Integer mappingYear, @RequestParam("specialPost") String specialPost, @RequestParam("affirm") String affirm,
                                    @RequestParam("userId") Long userId){
        System.out.println("我是添加技术人员信息");
        return mappingApiService.addTechnicist(files,majorType,name,idType,idNumber,age,sex, workYear,duty,title, school,graduationDate,degree,
                educationBackground,major, titleMajor,startTime,titleTime, startContract,endContract,post, mappingYear,specialPost,affirm, userId);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:查询单个技术人员信息
     *@param: []
     *@date: 15:36 2020/7/18
     *@return:
     *@throws:
     **/

    @GetMapping("/selectTechnicistById")
    public ResultData selectTechnicistById(@RequestParam("id") String id){
        return mappingApiService.selectTechnicistById(id);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:根据id删除技术人员信息
     *@param: []
     *@date: 15:36 2020/7/18
     *@return:
     *@throws:
     **/
    @DeleteMapping("/deleteTechnicistById")
    public ResultData deleteTechnicistById(@RequestParam("id") String id){
        return mappingApiService.deleteTechnicistById(id);
    }
    /**
     *@author: Cancer:栗仁杰
     *@description:修改技术人员信息
     *@param: []
     *@date: 15:37 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/updatedTechnicistById")
    public ResultData updatedTechnicistById(@RequestBody Technicist technicist){
        return mappingApiService.updatedTechnicistById(technicist);
    }















































}
