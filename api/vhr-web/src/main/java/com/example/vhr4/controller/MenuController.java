package com.example.vhr4.controller;

import com.example.vhr4.framework.entity.RespBean;
import com.example.vhr4.framework.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@RestController
public class MenuController {

    @Autowired
    IMenuService menuService;

    @GetMapping("/menus")
    public RespBean getMenusByHrId() {
        return menuService.getMenusByHrId();
    }
}
