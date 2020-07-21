package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.base.ResultData;
import com.aaa.mapper.RoleMapper;
import com.aaa.mapper.RoleMenuMapper;
import com.aaa.model.Role;
import com.aaa.model.RoleMenu;
import com.aaa.vo.RoleVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.aaa.status.DeleteStatus.DELETE_DATA_FAILED;
import static com.aaa.status.DeleteStatus.DELETE_DATA_SUCCESS;
import static com.aaa.status.SelectStatus.SELECT_DATA_FAILED;
import static com.aaa.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author jyz
 * @date 2020/7/18 9:25
 **/
@Service
public class RoleService extends BaseService<Role> {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * @Author jyz
     * @Description //TODO 查询所有角色
     * @Date 9:33 2020/7/18
     * @Param []
     * @return com.aaa.base.ResultData
     **/
    public ResultData selectAllRole(){
        ResultData resultData = new ResultData();
        List<Role> roles = roleMapper.selectAll();
        if (null == roles || roles.size() <= 0){
            resultData.setCode(SELECT_DATA_FAILED.getCode());
            resultData.setMsg(SELECT_DATA_FAILED.getMsg());
        }else {
            resultData.setCode(SELECT_DATA_SUCCESS.getCode());
            resultData.setMsg(SELECT_DATA_SUCCESS.getMsg());
            resultData.setData(roles);
        }
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 分页查询
     * @Date 9:43 2020/7/18
     * @Param [roleVo]
     * @return com.aaa.base.ResultData
     **/
    public ResultData selectAllRoleByPage(RoleVo roleVo){
        ResultData resultData = new ResultData();
        PageInfo<Role> rolePageInfo = super.selectListByPage(roleVo.getRole(),roleVo.getPageNo(),roleVo.getPageSize());
        if (null == rolePageInfo || "".equals(rolePageInfo)){
            resultData.setCode(SELECT_DATA_FAILED.getCode());
            resultData.setMsg(SELECT_DATA_FAILED.getMsg());
        }else {
            resultData.setCode(SELECT_DATA_SUCCESS.getCode());
            resultData.setMsg(SELECT_DATA_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author jyz
     * @Description //TODO 删除角色
     * @Date 10:00 2020/7/18
     * @Param [roleId]
     * @return com.aaa.base.ResultData
     **/
    public ResultData deleteRole(Long roleId){
        ResultData resultData = new ResultData();
        int i = roleMapper.deleteByPrimaryKey(roleId);
        if (i > 0){
            List<RoleMenu> roleMenus = roleMenuMapper.selectByRoleId(roleId);
            if (roleMenus.size() > 0){
                int i1 = roleMenuMapper.deleteRoleMenu(roleId);
                if (i1 > 0){
                    resultData.setCode(DELETE_DATA_SUCCESS.getCode());
                    resultData.setMsg(DELETE_DATA_SUCCESS.getMsg());
                    return resultData;
                }else {
                resultData.setCode(DELETE_DATA_FAILED.getCode());
                resultData.setMsg(DELETE_DATA_FAILED.getCode());
                return resultData;
            }
        }else {
            resultData.setCode("20009");
            resultData.setMsg("没有权限");
            return resultData;
        }
    }else {
            resultData.setCode(DELETE_DATA_FAILED.getCode());
            resultData.setMsg(DELETE_DATA_FAILED.getMsg());
            return resultData;
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 新增角色和权限
     * @Date 10:24 2020/7/18
     * @Param [roleVo]
     * @return java.lang.Boolean
     **/
    public Boolean insertRole(RoleVo roleVo){
        Date date = new Date();
        roleVo.getRole().setCreateTime(date);
        int insert = roleMapper.insert(roleVo.getRole());
        if (insert > 0){
            if (null == roleVo.getMenuId() || "".equals(roleVo.getMenuId())){
                return true;
            }else {
                List<RoleMenu> list = new ArrayList<RoleMenu>();
                for (Long menuId : roleVo.getMenuId()){
                    RoleMenu rm = new RoleMenu();
                    rm.setMenuId(menuId);
                    rm.setRoleId(roleVo.getRole().getRoleId());
                    list.add(rm);
                }
                Integer i = roleMenuMapper.batchInsertRoleMenu(list);
                if (i > 0){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * @Author jyz
     * @Description //TODO 修改角色与权限
     * @Date 10:35 2020/7/18
     * @Param [roleVo]
     * @return java.lang.Boolean
     **/
    public Boolean updateRole(RoleVo roleVo){
        Date date = new Date();
        roleVo.getRole().setModifyTime(date);
        int i = roleMapper.updateByPrimaryKeySelective(roleVo.getRole());
        if (i > 0){
            List<RoleMenu> list = roleMenuMapper.selectByRoleId(roleVo.getRole().getRoleId());
            boolean equals = list.equals(roleVo.getMenuId());
            if (true == equals){
                return true;
            }else {
                List<RoleMenu> menus = roleMenuMapper.selectByRoleId(roleVo.getRole().getRoleId());
                if (menus.size() > 0){
                    int i1 = roleMenuMapper.deleteRoleMenu(roleVo.getRole().getRoleId());
                    if (i1 > 0){
                        if (null == roleVo.getMenuId() || "".equals(roleVo.getMenuId())){
                            return true;
                        }else {
                            List<RoleMenu> arr = new ArrayList<RoleMenu>();
                            for (Long mid : roleVo.getMenuId()){
                                RoleMenu rm = new RoleMenu();
                                rm.setMenuId(mid);
                                rm.setRoleId(roleVo.getRole().getRoleId());
                                arr.add(rm);
                            }
                            int i2 = roleMenuMapper.batchInsertRoleMenu(arr);
                            if (i2 > 0){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
