package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.model.*;
import com.aaa.vo.RoleVo;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.acl.LastOwnerException;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName IProjectService
 * @Description TODO
 * @Author jyz
 * @date 2020/7/15 15:02
 **/
@FeignClient(value = "project2-interface-provider")
public interface IProjectService {

    /**
     * @Author jyz
     * @Description //TODO 执行登录操作
     * @Date 15:08 2020/7/15
     * @Param [user]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);

    /**
     * @Author jyz
     * @Description //TODO 新增日志
     * @Date 15:08 2020/7/15
     * @Param [loginLog]
     * @return java.lang.Integer
     **/
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);

    /**
     * @Author jyz
     * @Description //TODO 注册新用户
     * @Date 9:54 2020/7/16
     * @Param [user]
     * @return java.lang.Integer
     **/
    @PostMapping("/addUser")
    ResultData insert(@RequestBody User user);

    /**
     * @Author jyz
     * @Description //TODO 导出用户信息
     * @Date 17:13 2020/7/16
     * @Param []
     * @return javax.xml.ws.Response
     **/
    @GetMapping("/exportExcle")
    Response exportExcle();

    /**
     * @Author jyz
     * @Description //TODO 逻辑删除
     * @Date 17:19 2020/7/16
     * @Param [user]
     * @return java.lang.Integer
     **/
    @PostMapping("/deleteUser")
    Integer delete(@RequestBody User user);

    /**
     * @Author jyz
     * @Description //TODO 批量删除用户
     * @Date 17:18 2020/7/16
     * @Param [ids]
     * @return com.aaa.base.ResultData
     **/
    @DeleteMapping("/delUser")
    ResultData delUser(@RequestBody List<Long> ids);

    /**
     * @Author jyz
     * @Description //TODO 用户信息修改
     * @Date 17:21 2020/7/16
     * @Param [user]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/updateUser")
    ResultData updateUser(@RequestBody User user);

    /**
     * @Author jyz
     * @Description //TODO 分页条件查询所有用户
     * @Date 17:22 2020/7/16
     * @Param [map]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectUser")
    ResultData selectUserAll(@RequestBody HashMap map);

    /**
     * @Author jyz
     * @Description //TODO 查询部门信息
     * @Date 11:07 2020/7/17
     * @Param [map]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllDept")
    ResultData selectAllDept(@RequestBody HashMap map);

    /**
     * @Author jyz
     * @Description //TODO 批量删除部门信息
     * @Date 11:08 2020/7/17
     * @Param [ids]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/delDept")
    ResultData delDept(@RequestBody List<Long> ids);

    /**
     * @Author jyz
     * @Description //TODO 添加部门信息
     * @Date 11:09 2020/7/17
     * @Param [dept]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/addDept")
    ResultData addDept(@RequestBody Dept dept);

    /**
     * @Author jyz
     * @Description //TODO 更改部门信息
     * @Date 11:10 2020/7/17
     * @Param [dept]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/updateDept")
    ResultData updateDept(@RequestBody Dept dept);

    /**
     * @Author jyz
     * @Description //TODO 查询菜单
     * @Date 15:28 2020/7/17
     * @Param []
     * @return java.util.List<com.aaa.model.Menu>
     **/
    @PostMapping("/selectAllMenus")
    List<Menu> selectAllMenus();

    /**
     * @Author jyz
     * @Description //TODO 添加菜单
     * @Date 15:29 2020/7/17
     * @Param [menu]
     * @return com.aaa.base.ResultData<com.aaa.model.Menu>
     **/
    @PostMapping("/insertMenusOrButton")
    ResultData<Menu> insertMenusOrButton(@RequestBody Menu menu);

    /**
     * @Author jyz
     * @Description //TODO 修改菜单
     * @Date 15:31 2020/7/17
     * @Param [menu]
     * @return com.aaa.base.ResultData<com.aaa.model.Menu>
     **/
    @PostMapping("/updateMenusOrButton")
    ResultData<Menu> updateMenusOrButton(@RequestBody Menu menu);

    /**
     * @Author jyz
     * @Description //TODO 删除菜单
     * @Date 15:32 2020/7/17
     * @Param [menuId]
     * @return com.aaa.base.ResultData<com.aaa.model.Menu>
     **/
    @PostMapping("/deleteMenusOrButton")
    ResultData<Menu> deleteMenusOrButton(@RequestParam("menuId") Long menuId);
    /**
     * @Author yao
     * TODO aaa
     * @Description ////测绘项目管理，项目名称模糊查询，类型 ，日期精确查询
     * @Date 2020/7/17
     * @Param
     * @return
     **/
    @PostMapping("/projectSelect")
    ResultData<MappingProject> projectSelect(@RequestBody MappingProject mappingProject);
    /**
     * @Author yao
     * @Description //通过字段查询所有项目的类型和开工日期、分组
     * @Date 2020/7/17
     * @Param
     * @return
     **/
    @PostMapping("/selectName")
    ResultData<MappingProject> selectName(@RequestParam("name") MappingProject mappingProject);
    /**
     * @Author yao
     * @Description //通过id查询项目
     * @Date 2020/7/17
     * @Param
     * @return
     **/
    @PostMapping("/projectDetail")
    ResultData<MappingProject> projectDetail(@RequestParam("id") MappingProject mappingProject);
    /**
     * @Author yao
     * @Description 通过id修改项目
     * @Date 2020/7/19
     * @Param
     * @return
     **/
    @PostMapping("/project/updateById")
    Integer updateById(@RequestBody MappingProject manProject);
    /**
     * @Author yao
     * @Description 项目添加
     * @Date 2020/7/21
     * @Param
     * @return
     **/
    @PostMapping("/addProject")
    ResultData<MappingProject>addProject(@RequestBody MappingProject mappingProject);
    /**
     * @Author yao
     * @Description 查询所有测绘成果
     * @Date 2020/7/18
     * @Param
     * @return
     **/
    @PostMapping("/selectAllResultCommit")
    ResultData selectAllResultCommit(@RequestBody  HashMap hashMap);
    /**
     * @Author yao
     * @Description 查询所有测绘类型
     * @Date 2020/7/18
     * @Param
     * @return
     **/
    @PostMapping("/selectMapType")
    ResultData selectMapType();
    /**
     * @Author yao
     * @Description 查询测绘类型的详细信息
     * @Date 2020/7/18
     * @Param
     * @return
     **/
    @PostMapping("/resultDetail")
    ResultData resultDetail(@RequestParam("id") String id);

    /**
     * @Author jyz
     * @Description //TODO 查询字典信息
     * @Date 20:14 2020/7/17
     * @Param [hashMap]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllDictByPage")
    ResultData selectAllDictByPage(@RequestBody HashMap hashMap) throws Exception;

    /**
     * @Author jyz
     * @Description //TODO 新增字典信息
     * @Date 20:15 2020/7/17
     * @Param [dict]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/addDict")
    ResultData addDict(@RequestBody Dict dict);

    /**
     * @Author jyz
     * @Description //TODO 删除字典信息
     * @Date 20:15 2020/7/17
     * @Param [ids]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/delDictsById")
    ResultData delDictsById(@RequestBody List<Long> ids);

    /**
     * @Author jyz
     * @Description //TODO 更改字典信息
     * @Date 20:16 2020/7/17
     * @Param [dict]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/updateDict")
    ResultData updateDict(@RequestBody Dict dict);

    /**
     * @Author jyz
     * @Description //TODO 查询所有角色信息
     * @Date 11:28 2020/7/18
     * @Param []
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllRole")
    ResultData selectAllRole();

    /**
     * @Author jyz
     * @Description //TODO 分页查询
     * @Date 11:27 2020/7/18
     * @Param [roleVo]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllRolePage")
    ResultData selectAllRoleByPage(@RequestBody RoleVo roleVo);

    /**
     * @Author jyz
     * @Description //TODO 删除角色信息
     * @Date 11:28 2020/7/18
     * @Param [roleId]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/deleteRole")
    ResultData deleteRole(@RequestParam("roleId") Long roleId);

    /**
     * @Author jyz
     * @Description //TODO 添加角色和权限
     * @Date 11:28 2020/7/18
     * @Param [roleVo]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/insertRole")
    ResultData insertRole (@RequestBody RoleVo roleVo);

    /**
     * @Author jyz
     * @Description //TODO 更改角色和权限
     * @Date 11:29 2020/7/18
     * @Param [roleVo]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/updateRole")
    ResultData updateRole(@RequestBody RoleVo roleVo);
    /**
     *@author: Cancer:栗仁杰
     *@description:查询抽查人员
     *@param: []
     *@date: 16:41 2020/7/21
     *@return:
     *@throws:
     **/
    @PostMapping("/checkPerson/selectAllCheckPerson")
    ResultData selectAllCheckPerson(@RequestBody HashMap map);
    /**
     *@author: Cancer:栗仁杰
     *@description:添加抽查人员
     *@param: []
     *@date: 16:50 2020/7/21
     *@return:
     *@throws:
     **/
    @PostMapping("checkPerson/addCheckPerson")
    ResultData addCheckPerson(@RequestBody CheckPerson checkPerson);
    /**
     *@author: Cancer:栗仁杰
     *@description:修改抽查人员信息
     *@param: []
     *@date: 16:56 2020/7/21
     *@return:
     *@throws:
     **/
    @PostMapping("checkPerson/updateCheckPerson")
    ResultData updateCheckPerson(@RequestBody CheckPerson checkPerson);
    /**
     *@author: Cancer:栗仁杰
     *@description:删除抽查人员
     *@param: []
     *@date: 17:02 2020/7/21
     *@return:
     *@throws:
     **/
    @DeleteMapping("/checkPerson/delCheckPerson")
    ResultData delCheckPerson(@RequestBody List<Long> ids);

    /**
     * @Author jyz
     * @Description //TODO 文件上传
     * @Date 19:35 2020/7/22
     * @Param [file]
     * @return java.lang.Boolean
     **/
    @PostMapping("/upload")
    Boolean upload(@RequestParam("file") MultipartFile file);
}
