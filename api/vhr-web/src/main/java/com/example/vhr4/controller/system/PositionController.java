package com.example.vhr4.controller.system;

import com.example.vhr4.framework.entity.RespBean;
import com.example.vhr4.framework.entity.RespPageBean;
import com.example.vhr4.system.entity.Position;
import com.example.vhr4.system.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@RestController
@RequestMapping("/system/basic/position")
public class PositionController {

    @Autowired
    IPositionService positionService;

    @GetMapping("/{id}")
    public RespBean getPositionById(@PathVariable Integer id) {
        return RespBean.ok(null, positionService.getById(id));
    }

    @GetMapping
    public RespPageBean getPositionsByPage(@RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "10") Integer size) {
        return positionService.getPositionsByPage(page, size);
    }

    @PutMapping
    public RespBean updatePositionById(@RequestBody Position position) {
        return positionService.updateById(position) ? RespBean.ok("更新成功") : RespBean.error("更新失败");
    }

    @PostMapping
    public RespBean addPosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id) {
        return positionService.deletePositionById(id);
    }
}
