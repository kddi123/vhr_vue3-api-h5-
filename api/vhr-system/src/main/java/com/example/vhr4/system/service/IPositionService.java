package com.example.vhr4.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vhr4.framework.entity.RespBean;
import com.example.vhr4.framework.entity.RespPageBean;
import com.example.vhr4.system.entity.Position;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jeanyung
 * @since 2025-03-03
 */
public interface IPositionService extends IService<Position> {

    RespPageBean getPositionsByPage(Integer page, Integer size);

    RespBean addPosition(Position position);

    RespBean deletePositionById(Integer id);
}
