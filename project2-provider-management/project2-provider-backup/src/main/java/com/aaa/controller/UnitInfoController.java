package com.aaa.controller;

import cn.hutool.core.date.DateUtil;
import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.model.Principal;
import com.aaa.model.Technicist;
import com.aaa.service.MappingUnitService;
import com.aaa.service.PrincipalService;
import com.aaa.service.TechnicistService;
import com.aaa.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.aaa.status.AddStatus.ADD_DATA_SUCCESS;
import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * @Company: AAA软件教育
 * @Author: Cancer:栗仁杰
 * @Date: Created in 2020/7/17 15:19
 * @Description:
 */
@RestController
@RequestMapping("/unit")
public class UnitInfoController extends CommonController<MappingUnit> {
    @Autowired
    private PrincipalService principalService;

    @Autowired
    private TechnicistService technicistService;

    @Autowired
    private MappingUnitService mappingUnitService;

    @Autowired
    private UploadService uploadService;
    /**
     *@author: Cancer:栗仁杰
     *@description:
     *    查询单位基本信息
     *@param: []
     *@date:  2020/7/17
     *@return:
     *@throws:
     **/
    @PostMapping("/selectUnitInfo")
    public ResultData selectUnitInfo(@RequestParam("userId") String userId){
        MappingUnit unit = new MappingUnit();
        unit.setUserId(Long.valueOf(userId));
        MappingUnit mappingUnit = mappingUnitService.selectUnitInfo(unit);
        if (mappingUnit != null && !"".equals(mappingUnit) ) {
            return super.selectSuccess(mappingUnit);
        }else {
            return super.selectFailed();
        }
    }
/**
 *@author: Cancer:栗仁杰
 *@description:修改单位信息
 *@param: []
 *@date: 19:21 2020/7/17
 *@return:
 *@throws:
 **/
@PostMapping("/updateUnitInfo")
ResultData updateUnitInfo(@RequestBody MappingUnit mappingUnit){
    mappingUnit.setModifyTime(DateUtil.now());
    int i = mappingUnitService.updateUnitInfo(mappingUnit);
    if (i >0) {
        return super.updateSuccess();
    }else {
        return super.updateFailed();
    }
}
 /**
 *@author: Cancer:栗仁杰
 *@description:查询单位中的全部负责人
 *@param: []
 *@date: 20:16 2020/7/17
 *@return:
 *@throws:
 **/

  @GetMapping("/selectAllPrincipal")
  ResultData selectAllPrincipal(@RequestParam("userId") String userId){
      Principal principal = new Principal().setUserId(Long.valueOf(userId));
      List<Principal> principals = null;
      try {
          principals = principalService.selectList(principal);
      }catch (Exception e){
          e.printStackTrace();
      }
      if (principals != null && !principals.isEmpty()) {
          return  super.selectSuccess(principals);
      }else {
          return super.selectFailed();
      }
  }
  /**
   *@author: Cancer:栗仁杰
   *@description:查询单个负责人的信息
   *@param: []
   *@date: 9:06 2020/7/18
   *@return:
   *@throws:
   **/
  @GetMapping("/selectPrincipalById")
  public ResultData selectPrincipalById(@RequestParam("id") String id){
      Map<String,Object> resultMap = principalService.selectPrincipalById(id);
      if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
          return super.selectSuccess(resultMap.get("data"));
      }else{
          return super.selectFailed();
      }
  }
  /**
   *@author: Cancer:栗仁杰
   *@description:查询全部技术员信息
   *@param: []
   *@date: 20:26 2020/7/17
   *@return:
   *@throws:
   **/
     @GetMapping("/selectAllTechnicist")
     ResultData selectAllTechnicist(@RequestParam("userId") String userId){
         Technicist technicist = new Technicist().setUserId(Long.valueOf(userId));
         List<Technicist> technicists = null;
         try {
             technicists = technicistService.selectList(technicist);
         }catch (Exception e){
             e.printStackTrace();;
         }
         if (technicists != null && !technicists.isEmpty()) {
             return super.selectSuccess(technicists);
         }else {
             return  super.selectFailed();
         }
     }
     /**
      *@author: Cancer:栗仁杰
      *@description:删除单个负责人的信息
      *@param: []
      *@date: 9:09 2020/7/18
      *@return:
      *@throws:
      **/

     @DeleteMapping("/deletePrincipalById")
     ResultData deletePrincipalById(@RequestParam("id") String id){
         int i = principalService.deletePrincipalById(id);
         if (i > 0){
             return super.deleteSuccess();
         }
         return super.deleteFailed();
     }
         /**
      *@author: Cancer:栗仁杰
      *@description:添加技术人员信息
      *@param: []
      *@date: 20:45 2020/7/17
      *@return:
      *@throws:
      **/

     @PostMapping(value = "addTechnicist",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
     ResultData addTechnicist(@RequestParam("files") MultipartFile[] files, @RequestParam("majorType") String majorType, @RequestParam("name") String name, @RequestParam("idType") String idType,
                              @RequestParam("idNumber") String idNumber, @RequestParam("age") Integer age, @RequestParam("sex") Integer sex,
                              @RequestParam("workYear") Integer workYear, @RequestParam("duty") String duty, @RequestParam("title") String title,
                              @RequestParam("school") String school, @RequestParam("graduationDate") Date graduationDate, @RequestParam("degree") String degree,
                              @RequestParam("educationBackground") String educationBackground, @RequestParam("major") String major,
                              @RequestParam("titleMajor") String titleMajor, @RequestParam("startTime") Date startTime, @RequestParam("titleTime") Date titleTime,
                              @RequestParam("startContract") Date startContract, @RequestParam("endContract") Date endContract, @RequestParam("post") String post,
                              @RequestParam("mappingYear") Integer mappingYear, @RequestParam("specialPost") String specialPost, @RequestParam("affirm") String affirm,
                              @RequestParam("userId") Long userId){
         Technicist technicist = new Technicist();
         technicist.setMajorType(majorType).setName(name).setIdType(idType).setIdNumber(idNumber).setAge(age).setSex(sex).setWorkYear(workYear).setDuty(duty).setTitle(title)
                 .setSchool(school).setGraduationDate(graduationDate).setDegree(degree).setEducationBackground(educationBackground).setMajor(major).setTitleMajor(titleMajor)
                 .setStartTime(startTime).setTitleTime(titleTime).setStartContract(startContract).setEndContract(endContract).setPost(post).setMappingYear(mappingYear)
                 .setSpecialPost(specialPost).setAffirm(affirm).setUserId(userId);
         Map<String, Object> addTechnicistMapper = technicistService.addTechnicist(technicist, files, uploadService);
         if (ADD_DATA_SUCCESS.getCode().equals(addTechnicistMapper.get("code"))){
             return super.addSuccess();
         }else {
             return super.addFailed();
         }
     }

/**
 *@author: Cancer:栗仁杰
 *@description:查询单个技术人员信息
 *@param: []
 *@date: 22:53 2020/7/17
 *@return:
 *@throws:
 **/

@GetMapping("/selectTechnicistById")
ResultData selectTechnicistById(@RequestParam("id") String id){
    Map<String,Object> resultMap = technicistService.selectTechnicistById(id);
    if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
        return super.selectSuccess(resultMap.get("data"));
    }else{
        return super.selectFailed();
    }
}
/**
 *@author: Cancer:栗仁杰
 *@description:根据id删除技术人员信息
 *@param: []
 *@date: 22:58 2020/7/17
 *@return:
 *@throws:
 **/

@DeleteMapping("/deleteTechnicistById")
ResultData deleteTechnicistById(@RequestParam("id") String id){
    int i = technicistService.deleteTechnicistById(id);
    if (i > 0){
        return super.deleteSuccess();
    }
    return super.deleteFailed();
}

/**
 *@author: Cancer:栗仁杰
 *@description:
 * 修改技术人员信息
 *@param: []
 *@date: 23:02 2020/7/17
 *@return:
 *@throws:
 **/

@PostMapping("/updateTechnicist")
ResultData updateTechnicist(@RequestBody Technicist technicist){
    //获取修改时间，并且放入到对象中
    technicist.setModifyTime(DateUtil.now());
    //修改技术人员信息
    int res = technicistService.updateTechnicist(technicist);
    if(res > 0){
        return super.updateSuccess();
    }else{
        return super.updateFailed();
    }
}

/**
 *@author: Cancer:栗仁杰
 *@description: 添加单位负责人
 *@param: []
 *@date: 23:04 2020/7/17
 *@return:
 *@throws:
 **/
@PostMapping(value = "/addPrincipal",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
ResultData addPrincipal(@RequestParam("files") MultipartFile[] files, @RequestParam("type") String type, @RequestParam("name") String name, @RequestParam("idType") String idType,
                        @RequestParam("idNumber") String idNumber, @RequestParam("age") Integer age, @RequestParam("sex") Integer sex,
                        @RequestParam("workYear") Integer workYear, @RequestParam("duty") String duty, @RequestParam("title") String title,
                        @RequestParam("major") String major, @RequestParam("mappingYear") Integer mappingYear, @RequestParam("userId") Long userId){
    Principal principal = new Principal();
    principal.setType(type).setName(name).setIdType(idType).setIdNumber(idNumber).setAge(age).
            setSex(sex).setWorkYear(workYear).setDuty(duty).setTitle(title).setMajor(major).setMappingYear(mappingYear).setUserId(userId);
    Map<String,Object> resultMap = principalService.addPrincipal(principal,files,uploadService);
    if (ADD_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
        return super.addSuccess();
    }else {
        return super.addFailed();
    }
}


/**
 *@author: Cancer:栗仁杰
 *@description:添加测绘成果及档案管理
 *@param: []
 *@date: 9:12 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping("/addUnit")
public ResultData addUnit(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2
        , @RequestParam("file3") MultipartFile file3, @RequestParam("file4") MultipartFile file4, @RequestParam("unitId") Long unitId){
    Map<String,Object> resultMap = mappingUnitService.addUnit(file1,file2,file3,file4,unitId,uploadService);
    if (ADD_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
        return super.addSuccess();
    }else {
        return super.addFailed();
    }
}












    @Override
    public BaseService<MappingUnit> getBaseService() {
        return null;
    }
}
