package com.energy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.energy.entity.CProduct;
import com.energy.entity.CScenario;
import com.energy.mapper.CProductMapper;
import com.energy.result.Result;
import com.energy.service.CProductService;
import com.energy.service.CScenarioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author lenovo
 * @description 针对表【c_product(产品表)】的数据库操作Service实现
 * @createDate 2024-11-05 14:35:23
 */
@Service
public class CProductServiceImpl extends ServiceImpl<CProductMapper, CProduct>
        implements CProductService {

    @Resource
    private CScenarioService scenarioService;

    @Override
    public void modifyStatus(Integer stu, List<Long> list) {
        for (Long id : list) {
            CProduct dish = this.getById(id);
            dish.setStatus(stu);
            this.updateById(dish);
        }
    }

    @Override
    public Page<CProduct> getPage(Integer page, Integer pageSize, String name) {
        //构造分页构造器对象
        Page<CProduct> pageInfo = new Page<>(page, pageSize);

        //条件构造器
        LambdaQueryWrapper<CProduct> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(name != null, CProduct::getTitle, name);
        //添加排序条件
        queryWrapper.orderByDesc(CProduct::getCreateTime);
        this.page(pageInfo, queryWrapper);
        pageInfo.getRecords().forEach(record -> {
            // 假设 CProduct 中有 getCScenarioId 方法，并且 scenarioService.getById 返回 Scenario 对象
            String scenarioTitle = scenarioService.getById(record.getScenarioId()).getTitle();
            // 将 scenario 的 title 设置到 CProduct 中（假设 CProduct 中有 setScenarioTitle 方法）
            record.setScenario(scenarioTitle);
        });

        return pageInfo;

    }

    @Override
    public List<CProduct> orderByType(String type) {
        LambdaQueryWrapper<CProduct> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(type != null, CProduct::getScenarioId, type);
        return this.list(queryWrapper);
    }

    @Override
    public CProduct getDifferById(Long id) {
        CProduct product = this.getById(id);
        product.setScenario(product.getScenarioId());
        return product;
    }

    @Override
    public void saveByListId(CProduct product) {
        product.setScenarioId(processLastWord(product.getScenarioId()));
        this.save(product);
    }

    @Override
    public void updateByListId(CProduct product) {
        product.setScenarioId(processLastWord(product.getScenarioId()));
        this.updateById(product);
    }

    public String processLastWord(String input) {
        // 判断输入是否为空
        if (input == null || input.isEmpty()) {
            return input; // 如果为空，直接返回原始字符串
        }

        // 判断最后一个字符是否是中文逗号
        if (input.endsWith(",")||input.endsWith("，")) {
            // 如果是中文逗号，去掉最后一个字符
            return input.substring(0, input.length() - 1);
        }

        // 如果不是中文逗号，直接返回原字符串
        return input;
    }
}




