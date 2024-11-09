package com.energy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.energy.constant.MessageConstant;
import com.energy.entity.CHome;
import com.energy.entity.CPicture;
import com.energy.result.Result;
import com.energy.service.CPictureService;
import com.energy.service.impl.CPictureServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cn/picture")
@Slf4j
public class CPictureController {

    @Resource
    private CPictureService pictureService;

    @GetMapping("/{type}")
    public Result<CPicture> get(@PathVariable String type){

        LambdaQueryWrapper<CPicture> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CPicture::getName,type);
        return Result.success(pictureService.getOne(lambdaQueryWrapper));
    }

    @PutMapping
    public Result<String> update(@RequestBody CPicture picture){
        pictureService.updateById(picture);

        return Result.success(MessageConstant.EDIT_SUCCESS);
    }

    @GetMapping("/page")
    public Result<Page> homeInfo(int page, int pageSize) {
        return Result.success(pictureService.getHomeInfo(page,pageSize));
    }
    @GetMapping("/info/{id}")
    public Result<CPicture> homeInfo(@PathVariable Long id){
        return Result.success(pictureService.getById(id));
    }

}
