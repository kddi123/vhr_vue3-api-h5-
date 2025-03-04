package com.example.vhr4.framework.entity.vo;


import com.example.vhr4.framework.entity.Menu;
import com.example.vhr4.framework.entity.Role;

import java.util.List;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class MenuWithRole extends Menu {
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
