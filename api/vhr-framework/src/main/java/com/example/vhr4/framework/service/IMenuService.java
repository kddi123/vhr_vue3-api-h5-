package com.example.vhr4.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vhr4.framework.entity.Menu;
import com.example.vhr4.framework.entity.RespBean;
import com.example.vhr4.framework.entity.vo.MenuWithRole;


import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author javaboy
 * @since 2024-01-03
 */
public interface IMenuService extends IService<Menu> {

    RespBean getMenusByHrId();

    List<MenuWithRole> getAllMenusWithRole();
}
