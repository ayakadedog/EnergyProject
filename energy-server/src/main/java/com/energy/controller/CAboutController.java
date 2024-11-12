package com.energy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.energy.constant.MessageConstant;
import com.energy.entity.CAbout;
import com.energy.entity.CAbout;
import com.energy.entity.CHome;
import com.energy.result.Result;
import com.energy.service.CAboutService;
import com.energy.service.CAboutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cn/about")
@Slf4j
public class CAboutController {
    @Resource
    private CAboutService aboutService;

    @GetMapping("/page")
    public Result<Page> aboutInfo(int page, int pageSize) {
        LambdaQueryWrapper<CAbout> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Page<CAbout> pageInfo = new Page(page, pageSize);
        return Result.success(aboutService.page(pageInfo,lambdaQueryWrapper));

    }

    @PostMapping("/update")
    public Result<Void> update(@RequestBody CAbout cAbout) {
        aboutService.updateById(cAbout);
        return Result.success();
    }

    @GetMapping("/info/{id}")
    public Result<CAbout> aboutInfo(@PathVariable Long id){
        return Result.success(aboutService.getById(id));
    }

    @PutMapping
    public Result<String> save(@RequestBody CAbout about) {
        aboutService.updateById(about);
        return Result.success(MessageConstant.ADD_SUC);
    }

    @GetMapping("/left")
    public Result<CAbout> getPictureLeft() {
        LambdaQueryWrapper<CAbout> lambdaQueryWrapper = new LambdaQueryWrapper<CAbout>().eq(CAbout::getType, "大图一");

        return Result.success(aboutService.getOne(lambdaQueryWrapper));
    }

    @GetMapping("/right")
    public Result<CAbout> getPictureRight() {
        LambdaQueryWrapper<CAbout> lambdaQueryWrapper = new LambdaQueryWrapper<CAbout>().eq(CAbout::getType, "大图二");

        return Result.success(aboutService.getOne(lambdaQueryWrapper));
    }
    @GetMapping("/win")
    public Result<List<CAbout>> getWin() {
        LambdaQueryWrapper<CAbout> lambdaQueryWrapper = new LambdaQueryWrapper<CAbout>().eq(CAbout::getType, "小图二");

        return Result.success(aboutService.list(lambdaQueryWrapper));
    }
    @GetMapping("/factory")
    public Result<List<CAbout>> getFactory() {
        LambdaQueryWrapper<CAbout> lambdaQueryWrapper = new LambdaQueryWrapper<CAbout>().eq(CAbout::getType, "小图一");

        return Result.success(aboutService.list(lambdaQueryWrapper));
    }
}
