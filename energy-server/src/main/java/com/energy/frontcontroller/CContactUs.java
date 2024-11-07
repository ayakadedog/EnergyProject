package com.energy.frontcontroller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.energy.constant.MessageConstant;
import com.energy.entity.CComment;
import com.energy.entity.CScenario;
import com.energy.result.Result;
import com.energy.service.CCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/cn/contact-us")
@Slf4j
public class CContactUs {
    @Resource
    private CCommentService cCommentService;

    @PostMapping("/sendMessage")
    public Result<String> addComment(@RequestBody CComment comment){
        comment.setCreateTime(LocalDateTime.now());
        comment.setPhone(null);
        cCommentService.save(comment);
        return Result.success(MessageConstant.Send_SUC);
    }

    @GetMapping("/page")
    public Result<Page> page(int page,int pageSize,String name){
        //构造分页构造器对象
        Page<CComment> pageInfo = new Page<>(page, pageSize);

        //条件构造器
        LambdaQueryWrapper<CComment> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(name != null, CComment::getName, name);
        //添加排序条件
        queryWrapper.orderByDesc(CComment::getCreateTime);

        return Result.success(cCommentService.page(pageInfo, queryWrapper));
    }

    @DeleteMapping("/orderDetail/{id}")
    public Result<String> deleteById(@PathVariable Long id){
        cCommentService.removeById(id);
        return Result.success(MessageConstant.DELETE_SUC);
    }
}
