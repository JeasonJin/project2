package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.service.IProjectService;
import com.aaa.vo.RoleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Author jyz
 * @date 2020/7/18 11:53
 **/
@RestController
@Api(value = "用户管理" ,tags = "用户管理接口")
public class RoleController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @Author jyz
     * @Description //TODO 获取所有角色信息
     * @Date 11:59 2020/7/18
     * @Param []
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllRole")
    @ApiModelProperty(value = "角色管理" , notes = "查询所有的角色的功能")
    public ResultData selectAllRole(){
        return iProjectService.selectAllRole();
    }

    /**
     * @Author jyz
     * @Description //TODO 分页查询
     * @Date 14:22 2020/7/18
     * @Param [roleVo]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllRoleByPage")
    @ApiModelProperty(value = "分页查询角色",notes = "查询所有角色带分页的功能")
    public ResultData selectAllRoleByPage (@RequestBody RoleVo roleVo){
        return iProjectService.selectAllRoleByPage(roleVo);
    }

    /**
     * @Author jyz
     * @Description //TODO 删除角色
     * @Date 14:22 2020/7/18
     * @Param [roleId]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/deleteRole")
    @ApiOperation(value = "删除角色", notes = "删除角色的功能")
    public ResultData deleteRole(@RequestParam("roleId") Long roleId){
        return iProjectService.deleteRole(roleId);
    }

    /**
     * @Author jyz
     * @Description //TODO 新增角色和权限
     * @Date 14:23 2020/7/18
     * @Param [roleVo]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/insertRole")
    @ApiOperation(value = "新增角色", notes = "新增角色的功能")
    public ResultData insertRole(@RequestBody RoleVo roleVo){
        return iProjectService.insertRole(roleVo);
    }

    /**
     * @Author jyz
     * @Description //TODO 修改角色权限
     * @Date 14:24 2020/7/18
     * @Param [roleVo]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/updateRole")
    @ApiOperation(value = "修改角色", notes = "修改角色的功能")
    public ResultData updateRole(@RequestBody RoleVo roleVo){
        return iProjectService.updateRole(roleVo);
    }
}
