package com.example.vhr4.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.vhr4.framework.entity.RespBean;
import com.example.vhr4.framework.entity.RespPageBean;
import com.example.vhr4.system.entity.Position;
import com.example.vhr4.system.mapper.PositionMapper;
import com.example.vhr4.system.service.IPositionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jeanyung
 * @since 2025-03-03
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {


    @Override
    public RespPageBean getPositionsByPage(Integer page, Integer size) {
        Page<Position> result = this.page(new Page<>(page, size));
        List<Position> records = result.getRecords();
        long total = result.getTotal();
        return new RespPageBean(total, records);
    }

    @Override
    public RespBean addPosition(Position position) {
        QueryWrapper<Position> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Position::getName,position.getName());
        Position addOne = getOne(queryWrapper);
        if (addOne == null) {
            //说明没有重复职位名
            position.setEnabled(true);
            position.setCreateDate(LocalDateTime.now());
            return save(position) ? RespBean.ok("添加成功") : RespBean.error("添加失败");
        }else {
            return   RespBean.error("职位名重复，添加失败");
        }
    }

    @Override
    public RespBean deletePositionById(Integer id) {
        Position one = getById(id);
        if (one == null) {
            //要删除的数据不存在
            return RespBean.error("数据不存在，删除失败");
        }
        return removeById(id) ? RespBean.ok("删除成功") : RespBean.ok("删除失败");
    }
}
