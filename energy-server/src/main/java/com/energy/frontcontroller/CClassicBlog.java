package com.energy.frontcontroller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.energy.constant.MessageConstant;
import com.energy.entity.CComment;
import com.energy.entity.CSupport;
import com.energy.result.Result;
import com.energy.service.CSupportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cn/classicBlog")
@Slf4j
public class CClassicBlog {
    @Resource
    private CSupportService cSupportService;

    @GetMapping("/page")
    public Result<Page> page(Integer page,Integer pageSize,String name){
        //构造分页构造器对象
        Page<CSupport> pageInfo = new Page<>(page, pageSize);

        //条件构造器
        LambdaQueryWrapper<CSupport> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(name != null, CSupport::getTitle, name);
        //添加排序条件
        queryWrapper.orderByDesc(CSupport::getId);

        return Result.success(cSupportService.page(pageInfo, queryWrapper));
    }

    @PostMapping("/addService")
    public Result<String> addService(@RequestBody CSupport support){
        if (support.getTitle()==null||support.getTitle().isEmpty()
                ||support.getUrl()==null||support.getUrl().isEmpty()
                ||support.getCategory()==null||support.getCategory().isEmpty()
                ||support.getContent()==null||support.getContent().isEmpty()
        ){
            return Result.error(MessageConstant.ADD_FAILED);
        }else {
            cSupportService.save(support);
            return Result.success(MessageConstant.ADD_SUC);
        }
    }

    @PostMapping("/updateService")
    public Result<String> updateService(@RequestBody CSupport support){
        if (support.getTitle()==null||support.getTitle().isEmpty()
                ||support.getUrl()==null||support.getUrl().isEmpty()
                ||support.getCategory()==null||support.getCategory().isEmpty()
                ||support.getContent()==null||support.getContent().isEmpty()
        ){
            return Result.error(MessageConstant.ADD_FAILED);
        }else {
            cSupportService.updateById(support);
            return Result.success(MessageConstant.ADD_SUC);
        }
    }

    @GetMapping("/getServiceDetail/{id}")
    public Result<CSupport> getServiceDetail(@PathVariable Long id){
        CSupport cSupport = cSupportService.getById(id);
        return Result.success(cSupport);
    }

    @DeleteMapping("/deleteServices")
    public Result<String> deleteServices(@RequestParam List<Long> ids){
        cSupportService.removeByIds(ids);
        return Result.success(MessageConstant.DELETE_SUC);
    }
}
