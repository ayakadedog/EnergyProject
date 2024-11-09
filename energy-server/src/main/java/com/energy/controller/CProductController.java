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
        productService.saveByListId(product);
        return Result.success(MessageConstant.ADD_SUC);
    }



    @GetMapping("/page")
    public Result<Page> page(Integer page, Integer pageSize, String name) {
        if (page == null || page <= 0) {
            page = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }

        return Result.success(productService.getPage(page, pageSize,name));
    }



    @GetMapping("/{id}")
    public Result<CProduct> get(@PathVariable Long id){

        CProduct product = productService.getDifferById(id);

        return Result.success(product);
    }


    @PutMapping
    public Result<String> update(@RequestBody CProduct product){
        productService.updateByListId(product);

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

    @GetMapping("/type")
    public Result<List<CProduct>> orderByType(@RequestParam(required = false) String type){

        List<CProduct> list = productService.orderByType(type);

        return Result.success(list);
    }
}
