package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Menu;
import com.aaa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName MenuController
 * @Description TODO
 * @Author jyz
 * @date 2020/7/17 15:04
 **/
@RestController
public class MenuController extends CommonController<Menu> {
    @Autowired
    private MenuService menuService;
    @Override
    public BaseService<Menu> getBaseService() {
        return menuService;
    }

    /**
     * @Author jyz
     * @Description //TODO 查询所有菜单
     * @Date 15:09 2020/7/17
     * @Param []
     * @return java.util.List<com.aaa.model.Menu>
     **/
    @PostMapping("/selectMenus")
    public List<Menu> selectAllMenus(){
        return menuService.selectAllMenus();
    }

    /**
     * @Author jyz
     * @Description //TODO 新增操作
     * @Date 15:12 2020/7/17
     * @Param [menu]
     * @return com.aaa.base.ResultData<com.aaa.model.Menu>
     **/
    @PostMapping("/insertMenusOrButton")
    public ResultData<Menu> insertMenusOrButton(@RequestBody Menu menu){
        Boolean aBoolean = menuService.insertMenuOrButton(menu);
        if (true == aBoolean){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 更改操作
     * @Date 15:15 2020/7/17
     * @Param [menu]
     * @return com.aaa.base.ResultData<com.aaa.model.Menu>
     **/
    @PostMapping("/updateMenusOrButton")
    public ResultData<Menu> updateMenusOrButton(@RequestBody Menu menu){
        Boolean aBoolean = menuService.updateMenuOrButton(menu);
        if (true == aBoolean){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * @Author jyz
     * @Description //TODO 删除操作
     * @Date 15:23 2020/7/17
     * @Param [menuId]
     * @return com.aaa.base.ResultData<com.aaa.model.Menu>
     **/
    @PostMapping("/deleteMenusOrButton")
    public ResultData<Menu> deleteMenusOrButton(@RequestParam("menuId") Long menuId){
        Boolean aBoolean = menuService.deleteMenuOrButton(menuId);
        if (true == aBoolean){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }
}
