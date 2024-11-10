package com.energy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.energy.constant.MessageConstant;
import com.energy.entity.CProduct;
import com.energy.entity.CScenario;
import com.energy.result.Result;
import com.energy.service.CProductService;
import com.energy.service.CScenarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 菜品管理
 */
@RestController
@RequestMapping("/cn/scenario")
@Slf4j
public class CScenarioController {
    @Resource
    private CScenarioService scenarioService;
    @Resource
    private CProductService productService;
    
    
    @PostMapping
    public Result<String> save(@RequestBody CScenario scenario) {
        scenario.setCreateTime(LocalDateTime.now());
        scenarioService.save(scenario);
        return Result.success(MessageConstant.ADD_SUC);
    }



    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String name) {

        //构造分页构造器对象
        Page<CScenario> pageInfo = new Page<>(page, pageSize);

        //条件构造器
        LambdaQueryWrapper<CScenario> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(name != null, CScenario::getTitle, name);
        //添加排序条件
        queryWrapper.orderByDesc(CScenario::getCreateTime);

        return Result.success(scenarioService.page(pageInfo, queryWrapper));
    }



    @GetMapping("/{id}")
    public Result<CScenario> get(@PathVariable Long id){

        CScenario scenario = scenarioService.getById(id);

        return Result.success(scenario);
    }


    @PutMapping
    public Result<String> update(@RequestBody CScenario scenario){
        scenarioService.updateById(scenario);

        return Result.success(MessageConstant.EDIT_SUCCESS);
    }

    @DeleteMapping
    public Result<String> deleteByIds(@RequestParam("ids") List<Long> ids){
        log.info(ids.toString());

        if(scenarioService.removeByIds(ids)){
            return Result.success(MessageConstant.DELETE_SUC);
        }else{
            return Result.success(MessageConstant.UNKNOWN_ERROR);
        }
    }


    @PostMapping("/status/{stu}")
    public Result<String> modifyStatusByIds(@PathVariable Integer stu,@RequestParam("ids") List<Long> ids){
        log.info(ids.toString());
        scenarioService.modifyStatus(stu,ids);

        return Result.success(MessageConstant.EDIT_SUCCESS);
    }

    @GetMapping("/list")
    public Result<List<CScenario>> list() {

        return Result.success(scenarioService.list(new LambdaQueryWrapper<CScenario>()));
    }

    @GetMapping("/type")
    public Result<List<CScenario>> orderByType(@RequestParam(required = false) String type){

        List<CScenario> list = scenarioService.orderByType(type);

        return Result.success(list);
    }

    @GetMapping("/picture/{id}")
    public Result<String> getPicture(@PathVariable Long id){

        CScenario scenario = scenarioService.getById(id);

        return Result.success(scenario.getPicture());
    }
    @GetMapping("/about/scenario/{id}")
    public Result<List<CScenario>> getAboutScenario(@PathVariable Long id){
        return scenarioService.getAboutScenario(id);
    }
}
