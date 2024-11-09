package com.energy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.energy.constant.MessageConstant;
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
    private CPictureServiceImpl pictureService;

    @GetMapping("/{type}")
    public Result<String> get(@PathVariable String type){

        LambdaQueryWrapper<CPicture> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CPicture::getName,type);
        String picture = pictureService.getOne(lambdaQueryWrapper).getPicture();
        return Result.success(picture);
    }

    @PutMapping
    public Result<String> update(@RequestBody CPicture picture){
        pictureService.updateById(picture);

        return Result.success(MessageConstant.EDIT_SUCCESS);
    }
}
