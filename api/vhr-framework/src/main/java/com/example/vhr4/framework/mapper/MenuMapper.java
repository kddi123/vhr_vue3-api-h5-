package com.example.vhr4.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vhr4.framework.entity.Menu;
import com.example.vhr4.framework.entity.vo.MenuVO;
import com.example.vhr4.framework.entity.vo.MenuWithRole;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author javaboy
 * @since 2024-01-03
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<MenuVO> getMenusByHrId(Integer hrid);

    List<MenuWithRole> getAllMenusWithRole();
}
