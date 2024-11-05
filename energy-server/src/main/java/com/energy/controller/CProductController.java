package com.energy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.energy.constant.MessageConstant;
import com.energy.entity.CProduct;
import com.energy.result.Result;
import com.energy.service.CProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 菜品管理
 */
@RestController
@RequestMapping("/cn/product")
@Slf4j
public class CProductController {
    @Resource
    private CProductService productService;
    
    
    @PostMapping
    public Result<String> save(@RequestBody CProduct product) {
        product.setCreateTime(LocalDateTime.now());
        productService.save(product);
        return Result.success(MessageConstant.ADD_SUC);
    }



    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String name) {

        //构造分页构造器对象
        Page<CProduct> pageInfo = new Page<>(page, pageSize);

        //条件构造器
        LambdaQueryWrapper<CProduct> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(name != null, CProduct::getTitle, name);
        //添加排序条件
        queryWrapper.orderByDesc(CProduct::getCreateTime);

        return Result.success(productService.page(pageInfo, queryWrapper));
    }



    @GetMapping("/{id}")
    public Result<CProduct> get(@PathVariable Long id){

        CProduct product = productService.getById(id);

        return Result.success(product);
    }


    @PutMapping
    public Result<String> update(@RequestBody CProduct product){
        productService.updateById(product);

        return Result.success(MessageConstant.EDIT_SUCCESS);
    }


    @DeleteMapping
    public Result<String> deleteByIds(@RequestParam("ids") List<Long> ids){
        log.info(ids.toString());

        if(productService.removeByIds(ids)){
            return Result.success(MessageConstant.DELETE_SUC);
        }else{
            return Result.success(MessageConstant.UNKNOWN_ERROR);
        }
    }


    @PostMapping("/status/{stu}")
    public Result<String> modifyStatusByIds(@PathVariable Integer stu,@RequestParam("ids") List<Long> ids){
        log.info(ids.toString());
        productService.modifyStatus(stu,ids);

        return Result.success(MessageConstant.EDIT_SUCCESS);
    }


}
