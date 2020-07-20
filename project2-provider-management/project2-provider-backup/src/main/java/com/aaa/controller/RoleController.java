package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Role;
import com.aaa.service.RoleService;
import com.aaa.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.status.DeleteStatus.DELETE_DATA_SUCCESS;
import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Author jyz
 * @date 2020/7/18 10:56
 **/
@RestController
public class RoleController extends CommonController<Role> {
    @Autowired
    private RoleService roleService;
    @Override
    public BaseService<Role> getBaseService() {
        return null;
    }

    /**
     * @Author jyz
     * @Description //TODO 查询所有的角色
     * @Date 11:04 2020/7/18
     * @Param []
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllRole")
    public ResultData selectAllRole(){
        ResultData resultData = roleService.selectAllRole();
        if (SELECT_DATA_SUCCESS.getCode().equals(resultData.getCode())){
            return selectSuccess(resultData.getData());
        }else {
            return selectFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 分页查询
     * @Date 11:07 2020/7/18
     * @Param [roleVo]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/selectAllRolePage")
    public ResultData selectAllRoleByPage(@RequestBody RoleVo roleVo){
        ResultData resultData = roleService.selectAllRoleByPage(roleVo);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultData.getCode())){
            return selectSuccess(resultData.getData());
        }else {
            return selectFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 删除角色
     * @Date 11:12 2020/7/18
     * @Param [roleId]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/deleteRole")
    public ResultData deleteRole(@RequestParam("roleId") Long roleId){
        ResultData resultData = roleService.deleteRole(roleId);
        if (resultData.getCode().equals(DELETE_DATA_SUCCESS.getCode())){
            return super.operationSuccess();
        }else{
            return super.operationFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 新增角色和权限
     * @Date 11:15 2020/7/18
     * @Param [roleVo]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/insertRole")
    public ResultData insertRole (@RequestBody RoleVo roleVo){
        Boolean aBoolean = roleService.insertRole(roleVo);
        if (true == aBoolean){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 修改角色及权限
     * @Date 11:19 2020/7/18
     * @Param [roleVo]
     * @return com.aaa.base.ResultData
     **/
    @PostMapping("/updateRole")
    public ResultData updateRole(@RequestBody RoleVo roleVo){
        Boolean aBoolean = roleService.updateRole(roleVo);
        if (aBoolean == true){
            return updateSuccess();
        }else {
            return updateFailed();
        }
    }
}
