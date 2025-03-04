package com.example.vhr4.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vhr4.framework.entity.Hr;
import com.example.vhr4.framework.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author javaboy
 * @since 2024-01-03
 */
@Mapper
public interface HrMapper extends BaseMapper<Hr> {

    List<Role> getHrRolesByHrId(@Param("hrid") Integer hrid);
}
