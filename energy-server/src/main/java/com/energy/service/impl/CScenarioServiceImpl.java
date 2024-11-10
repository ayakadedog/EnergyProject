package com.energy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.energy.entity.CProduct;
import com.energy.entity.CScenario;
import com.energy.mapper.CScenarioMapper;
import com.energy.result.Result;
import com.energy.service.CProductService;
import com.energy.service.CScenarioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lenovo
 * @description 针对表【c_scenario】的数据库操作Service实现
 * @createDate 2024-11-05 14:35:23
 */
@Service
public class CScenarioServiceImpl extends ServiceImpl<CScenarioMapper, CScenario>
        implements CScenarioService {

    @Resource
    private CProductService productService;

    @Override
    public void modifyStatus(Integer stu, List<Long> list) {
        for (Long ids : list) {
            CScenario dish = this.getById(ids);
            dish.setStatus(stu);
            this.updateById(dish);
        }
    }

    @Override
    public List<CScenario> orderByType(String type) {
        LambdaQueryWrapper<CScenario> queryWrapper = new LambdaQueryWrapper<>();
        List<CScenario> list = this.list(queryWrapper);
        list.forEach(product -> {

            String content = product.getContent();
            if (content.length() > 10) {
                content = content.substring(0, 10) + "..."; // 截取前 10 个字符，并加上 "..."
            }

            // 将 content 设置回 record
            product.setContent(content);

        });
        return list;
    }

    @Override
    public Result<List<CScenario>> getAboutScenario(Long id) {
        CProduct product = productService.getById(id);
        String scenario = product.getScenarioId();
        String[] arr = scenario.split(",");

        // 将 arr 转换为 List<Long>，便于传入查询条件
        List<Long> scenarioIds = Arrays.stream(arr)
                .map(Long::valueOf)  // 将 String 转换为 Long
                .collect(Collectors.toList());

        // 构建查询条件，查找所有 id 在 scenarioIds 列表中的 CScenario 记录
        LambdaQueryWrapper<CScenario> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(CScenario::getId, scenarioIds);

        // 执行查询，获取匹配的 CScenario 列表
        List<CScenario> scenarios = this.list(lambdaQueryWrapper);

        return Result.success(scenarios);
    }
}




