package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Menu;
import com.aaa.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName MenuController
 * @Description TODO
 * @Author jyz
 * @date 2020/7/17 15:32
 **/
@RestController
@Api(value = "菜单管理" ,tags = "菜单管理接口")
public class MenuController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @Author jyz
     * @Description //TODO 查询菜单
     * @Date 15:37 2020/7/17
     * @Param []
     * @return com.aaa.base.ResultData<com.aaa.model.Menu>
     **/
    @PostMapping("/selectAllMenus")
    @ApiOperation(value = "菜单管理",notes = "查询所有菜单的功能")
    public ResultData<Menu> selectAllMenus(){
        List<Menu> menus = iProjectService.selectAllMenus();
        if (null == menus || menus.size()< 0){
            return super.selectFailed();
        }
        return super.selectSuccess(menus);
    }

    /**
     * @Author jyz
     * @Description //TODO 添加菜单
     * @Date 15:39 2020/7/17
     * @Param [menu]
     * @return com.aaa.base.ResultData<com.aaa.model.Menu>
     **/
    @PostMapping("/insertMenusOrButton")
    @ApiOperation(value = "新增菜单或按钮", notes = "新增菜单或按钮的功能")
    public ResultData<Menu> insertMenusOrButton(@RequestBody Menu menu){
        return iProjectService.insertMenusOrButton(menu);
    }

    /**
     * @Author jyz
     * @Description //TODO 修改菜单
     * @Date 15:40 2020/7/17
     * @Param [menu]
     * @return com.aaa.base.ResultData<com.aaa.model.Menu>
     **/
    @PostMapping("/updateMenusOrButton")
    @ApiOperation(value = "修改菜单或按钮", notes = "修改菜单或按钮信息的功能")
    public ResultData<Menu> updateMenusOrButton(@RequestBody Menu menu){
        return iProjectService.updateMenusOrButton(menu);
    }

    /**
     * @Author jyz
     * @Description //TODO 删除菜单
     * @Date 15:41 2020/7/17
     * @Param [menuId]
     * @return com.aaa.base.ResultData<com.aaa.model.Menu>
     **/
    @PostMapping("/deleteMenusOrButton")
    @ApiOperation(value = "删除菜单或按钮", notes = "删除菜单或按钮的功能")
    public ResultData<Menu> deleteMenusOrButton(@RequestParam("menuId") Long menuId){
        return iProjectService.deleteMenusOrButton(menuId);
    }
}
