package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MenuMapper;
import com.aaa.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MenuService
 * @Description TODO
 * @Author jyz
 * @date 2020/7/17 14:29
 **/
@Service
public class MenuService extends BaseService<Menu> {
    @Autowired
    private MenuMapper menuMapper;
    /**
     * @Author jyz
     * @Description //TODO 获取菜单信息
     * @Date 14:30 2020/7/17
     * @Param []
     * @return java.util.List<com.aaa.model.Menu>
     **/
    public List<Menu> selectAllMenus(){
        //菜单树
        List<Menu> menuList = new ArrayList<Menu>();
        //菜单全部信息
        List<Menu> allMenusList = menuMapper.selectAll();
        if (null != allMenusList || allMenusList.size()>0){
            //拿到一级菜单信息
            for (int i = 0; i<allMenusList.size();i++){
                Menu menu = allMenusList.get(i);
                if (menu.getParentId() == 0){
                    //说明时一级菜单
                    menuList.add(menu);
                }
            }
            //为一级菜单设置子菜单
            for (Menu menu : menuList) {
                menu.setSubMenu(getSubMenu(menu.getMenuId(),allMenusList));
            }
        }
        return menuList;
    }

    /**
     * @Author jyz
     * @Description //TODO 获取上一级菜单的子菜单
     * @Date 14:43 2020/7/17
     * @Param [menuId, allMenus]
     * @return java.util.List<com.aaa.model.Menu>
     **/
    private List<Menu> getSubMenu(Long menuId, List<Menu> allMenus){
        List<Menu> subMenus = new ArrayList<Menu>();
        for (Menu menu : subMenus){
            menu.setSubMenu(getSubMenu(menu.getMenuId(),allMenus));
        }
        if (subMenus.size() == 0){
            return null;
        }
        return subMenus;
    }

    /**
     * @Author jyz
     * @Description //TODO 根据主键信息修改菜单或者按钮的信息
     * @Date 14:48 2020/7/17
     * @Param [menu]
     * @return java.lang.Boolean
     **/
    public Boolean updateMenuOrButton(Menu menu){
        Date date = new Date();
        menu.setCreateTime(date);
        try {
            Integer update = super.update(menu);
            if (update > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @Author jyz
     * @Description //TODO 新增按钮或菜单
     * @Date 15:02 2020/7/17
     * @Param [menu]
     * @return java.lang.Boolean
     **/
    public Boolean insertMenuOrButton(Menu menu){
        Date createTime = new Date();
        menu.setCreateTime(createTime);
        try {
            Integer add = super.add(menu);
            if (add > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @Author jyz
     * @Description //TODO 根据主键id删除菜单或按钮
     * @Date 15:04 2020/7/17
     * @Param [menuId]
     * @return java.lang.Boolean
     **/
    public Boolean deleteMenuOrButton(Long menuId){
        int i = menuMapper.deleteByPrimaryKey(menuId);
        if (i > 0){
            return true;
        }else {
            return false;
        }
    }
}
