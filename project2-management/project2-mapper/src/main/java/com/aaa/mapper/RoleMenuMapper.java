package com.aaa.mapper;

import com.aaa.model.RoleMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMenuMapper extends Mapper<RoleMenu> {
    /**
     * @Author jyz
     * @Description //TODO 在roleMenu表中删除
     * @Date 9:22 2020/7/18
     * @Param [roleId]
     * @return int
     **/
    int deleteRoleMenu(Long roleId);

    /**
     * @Author jyz
     * @Description //TODO 批量新增
     * @Date 9:23 2020/7/18
     * @Param [roleMenus]
     * @return int
     **/
    int batchInsertRoleMenu(List<RoleMenu> roleMenus);

    /**
     * @Author jyz
     * @Description //TODO 查询表中有无roleId
     * @Date 9:23 2020/7/18
     * @Param [roleId]
     * @return java.util.List<com.aaa.model.RoleMenu>
     **/
    List<RoleMenu> selectByRoleId(Long roleId);
}