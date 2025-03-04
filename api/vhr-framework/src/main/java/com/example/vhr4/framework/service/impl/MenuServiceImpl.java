package com.example.vhr4.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.vhr4.framework.entity.Hr;
import com.example.vhr4.framework.entity.Menu;
import com.example.vhr4.framework.entity.RespBean;
import com.example.vhr4.framework.entity.vo.MenuVO;
import com.example.vhr4.framework.entity.vo.MenuWithRole;
import com.example.vhr4.framework.mapper.MenuMapper;
import com.example.vhr4.framework.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author javaboy
 * @since 2024-01-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public RespBean getMenusByHrId() {
        //获取当前登录成功的用户信息
        Hr principal = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<MenuVO> menus = menuMapper.getMenusByHrId(principal.getId());
        return menus != null && menus.size() > 0 ? RespBean.ok("加载成功", menus) : RespBean.error("未加载到菜单数据");
    }

    @Override
    public List<MenuWithRole> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }
}
