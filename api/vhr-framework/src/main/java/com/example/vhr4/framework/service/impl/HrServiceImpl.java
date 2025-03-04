package com.example.vhr4.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.vhr4.framework.entity.Hr;
import com.example.vhr4.framework.mapper.HrMapper;
import com.example.vhr4.framework.service.IHrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author javaboy
 * @since 2024-01-03
 */
@Service
public class HrServiceImpl extends ServiceImpl<HrMapper, Hr> implements IHrService {

    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Hr> qw = new QueryWrapper<>();
        qw.lambda().eq(Hr::getUsername, username);
        //查询某一个具体的用户
        Hr hr = getOne(qw);
        if (hr == null) {
            throw new UsernameNotFoundException("用户不存在，登录失败");
        }
        hr.setRoles(hrMapper.getHrRolesByHrId(hr.getId()));
        return hr;
    }
}
