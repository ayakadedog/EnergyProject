package com.energy.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.energy.constant.MessageConstant;
import com.energy.dto.UserLoginDTO;
import com.energy.entity.CHome;
import com.energy.entity.CScenario;
import com.energy.result.Result;
import com.energy.service.CHomeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cn/home")
@Slf4j
public class CHomeController {
    @Resource
    private CHomeService homeService;

    @GetMapping("/page")
    public Result<Page> homeInfo(int page, int pageSize) {
        return Result.success(homeService.getHomeInfo(page,pageSize));
    }

    @PostMapping("/update")
    public Result<Void> update(@RequestBody CHome cHome) {
        homeService.updateById(cHome);
        return Result.success();
    }

    @GetMapping("/info/{id}")
    public Result<CHome> homeInfo(@PathVariable Long id){
        return Result.success(homeService.getById(id));
    }

    @GetMapping("/list")
    public Result<Page> homeList() {
        return Result.success(homeService.getHomeInfo(1,10));
    }
    @PutMapping
    public Result<String> save(@RequestBody CHome home) {
        homeService.updateById(home);
        return Result.success(MessageConstant.ADD_SUC);
    }
}
