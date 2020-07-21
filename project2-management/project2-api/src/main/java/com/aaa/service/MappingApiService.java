package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.config.FeignMultipartConfig;
import com.aaa.model.*;
import com.aaa.vo.UnitVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Company: AAA软件教育
 * @Author: Cancer:栗仁杰
 * @Date: Created in 2020/7/18 10:59
 * @Description:
 *          测绘管理中的api接口
 */
@FeignClient(value ="MAPPING-PROVIDER",configuration = FeignMultipartConfig.class)
public interface MappingApiService {
    /**
     *@author: Cancer:栗仁杰
     *@description:
     *      查询单位基本信息
     *@param: []
     *@date: 11:04 2020/7/18
     *@return:
     *@throws:
     **/
    @PostMapping("/unit/selectUnitInfo")
    ResultData selectUnitInfo(@RequestParam("userId") String userId);
/**
 *@author: Cancer:栗仁杰
 *@description:修改单位信息
 *@param: []
 *@date: 11:06 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping("/unit/updateUnitInfo")
ResultData updateUnitInfo(@RequestBody MappingUnit mappingUnit);
/**
 *@author: Cancer:栗仁杰
 *@description: 查询全部的单位负责人信息
 *@param: []
 *@date: 11:08 2020/7/18
 *@return:
 *@throws:
 **/
@GetMapping("/unit/selectAllPrincipal")
ResultData selectAllPrincipal(@RequestParam("userId") String userId);
/**
 *@author: Cancer:栗仁杰
 *@description:查询全部技术员信息
 *@param: []
 *@date: 11:08 2020/7/18
 *@return:
 *@throws:
 **/
@GetMapping("/unit/selectAllTechnicist")
ResultData selectAllTechnicist(@RequestParam("userId") String userId);
/**
 *@author: Cancer:栗仁杰
 *@description:
 *       ftp文件上传，因为feign只能发送默认普通类型，不能发送特殊类型，所以需要转换
 *                   让postmapping去接收MultipartFile类型
 *@param: []
 *@date: 11:09 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
Boolean upload(MultipartFile file);
/**
 *@author: Cancer:栗仁杰
 *@description:添加单位负责人
 *@param: []
 *@date: 11:10 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping(value = "/unit/addPrincipal",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
ResultData addPrincipal(@RequestPart(value = "files") MultipartFile[] files, @RequestParam("type") String type, @RequestParam("name") String name, @RequestParam("idType") String idType,
                        @RequestParam("idNumber") String idNumber, @RequestParam("age") Integer age, @RequestParam("sex") Integer sex,
                        @RequestParam("workYear") Integer workYear, @RequestParam("duty") String duty, @RequestParam("title") String title,
                        @RequestParam("major") String major, @RequestParam("mappingYear") Integer mappingYear, @RequestParam("userId") Long userId);
/**
 *@author: Cancer:栗仁杰
 *@description:查询单个负责人的信息
 *@param: []
 *@date: 11:10 2020/7/18
 *@return:
 *@throws:
 **/
@GetMapping("/unit/selectPrincipalById")
ResultData selectPrincipalById(@RequestParam("id") String id);
/**
 *@author: Cancer:栗仁杰
 *@description:删除单个负责人的信息
 *@param: []
 *@date: 11:11 2020/7/18
 *@return:
 *@throws:
 **/
@DeleteMapping("/unit/deletePrincipalById")
ResultData deletePrincipalById(@RequestParam("id") String id);
/**
 *@author: Cancer:栗仁杰
 *@description:添加测绘成果及档案管理
 *@param: []
 *@date: 11:11 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping(value = "/unit/addRecord",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
ResultData addRecord(@RequestPart("file1") MultipartFile file1, @RequestPart("file2") MultipartFile file2
        , @RequestPart("file3") MultipartFile file3, @RequestPart("file4") MultipartFile file4, @RequestParam("unitId") Long unitId);
/**
 *@author: Cancer:栗仁杰
 *@description:查询项目
 *@param: []
 *@date: 11:12 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping("/project/allPro")
List<MappingProject> selectAllPros(@RequestParam("userId") Long userId);
/**
 *@author: Cancer:栗仁杰
 *@description:通过id查询项目
 *@param: []
 *@date: 11:12 2020/7/18
 *@return:
 *@throws:
 **/
@GetMapping("/project/selectById")
MappingProject selectById(@RequestParam("id") Long id);
/**
 *@author: Cancer:栗仁杰
 *@description:添加技术人员信息
 *@param: []
 *@date: 11:13 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping(value = "/unit/addTechnicist",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
ResultData addTechnicist(@RequestPart(value = "files") MultipartFile[] files, @RequestParam("majorType") String majorType, @RequestParam("name") String name, @RequestParam("idType") String idType,
                         @RequestParam("idNumber") String idNumber, @RequestParam("age") Integer age, @RequestParam("sex") Integer sex,
                         @RequestParam("workYear") Integer workYear, @RequestParam("duty") String duty, @RequestParam("title") String title,
                         @RequestParam("school") String school, @RequestParam("graduationDate") String graduationDate, @RequestParam("degree") String degree,
                         @RequestParam("educationBackground") String educationBackground, @RequestParam("major") String major,
                         @RequestParam("titleMajor") String titleMajor, @RequestParam("startTime") String startTime, @RequestParam("titleTime") String titleTime,
                         @RequestParam("startContract") String startContract, @RequestParam("endContract") String endContract, @RequestParam("post") String post,
                         @RequestParam("mappingYear") Integer mappingYear, @RequestParam("specialPost") String specialPost, @RequestParam("affirm") String affirm,
                         @RequestParam("userId") Long userId);
/**
 *@author: Cancer:栗仁杰
 *@description: 查询单个技术人员信息
 *@param: []
 *@date: 11:13 2020/7/18
 *@return:
 *@throws:
 **/
@GetMapping("/unit/selectTechnicistById")
ResultData selectTechnicistById(@RequestParam("id") String id);
/**
 *@author: Cancer:栗仁杰
 *@description:根据id删除技术人员信息
 *@param: []
 *@date: 11:14 2020/7/18
 *@return:
 *@throws:
 **/
@DeleteMapping("/unit/deleteTechnicistById")
ResultData deleteTechnicistById(@RequestParam("id") String id);
/**
 *@author: Cancer:栗仁杰
 *@description:修改技术人员信息
 *@param: []
 *@date: 11:14 2020/7/18
 *@return:
 *@throws:
 **/

@PostMapping("/unit/updatedTechnicistById")
ResultData updatedTechnicistById(@RequestBody Technicist technicist);

    /**
     * @author: Cancer:栗仁杰
     * @description:通过id修改项目
     * @param: []
     * @date: 11:14 2020/7/18
     * @return:
     * @throws:
     **/
    @PostMapping("/project/updateById")
    Integer updateById(@RequestBody MappingProject mappingProject) ;


    /**
 *@author: Cancer:栗仁杰
 *@description:单位审核--分页查询单位列表
 *@param: []
 *@date:  2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping("/mappingUnit/selectUnit")
ResultData selectUnit(@RequestBody UnitVo unitVo);
/**
 *@author: Cancer:栗仁杰
 *@description:查询单位修改待审核信息
 *@param: []
 *@date: 11:15 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping("/mappingUnit/selectUpdateUnit")
ResultData selectUpdateUnit(@RequestBody UnitVo unitVo);
/**
 *@author: Cancer:栗仁杰
 *@description: 查询单位注册待审核信息
 *@param: []
 *@date: 11:16 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping("/mappingUnit/selectRegistrationUnit")
ResultData selectRegistrationUnit(@RequestBody UnitVo unitVo);
/**
 *@author: Cancer:栗仁杰
 *@description:修改单位分值
 *@param: []
 *@date: 11:17 2020/7/18
 *@return:
 *@throws:
 **/

@PostMapping("/mappingUnit/updateScore")
ResultData updateScore(@RequestBody Score score);
/**
 *@author: Cancer:栗仁杰
 *@description: 根据单位id查询分值日志
 *@param: []
 *@date: 11:17 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping("/mappingUnit/selectScore")
ResultData selectScore(@RequestParam("unitId") Integer unitId);
/**
 *@author: Cancer:栗仁杰
 *@description:根据单位id查询审核日志
 *@param: []
 *@date: 11:19 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping("/mappingUnit/selectAudit")
ResultData selectAudit(@RequestParam("refId") Integer refId);
/**
 *@author: Cancer:栗仁杰
 *@description:审核
 *@param: []
 *@date: 11:20 2020/7/18
 *@return:
 *@throws:
 **/
@PostMapping("/mappingUnit/sceneUnit")
ResultData sceneUnit(@RequestBody Audit audit);
}
