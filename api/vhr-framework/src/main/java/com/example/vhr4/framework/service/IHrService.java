package com.example.vhr4.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.vhr4.framework.entity.Hr;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author javaboy
 * @since 2024-01-03
 */
public interface IHrService extends IService<Hr>, UserDetailsService {

}
