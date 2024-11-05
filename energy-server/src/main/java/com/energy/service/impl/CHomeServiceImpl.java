package com.energy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.energy.entity.CHome;
import com.energy.mapper.CHomeMapper;
import com.energy.result.Result;
import com.energy.service.CHomeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【c_home】的数据库操作Service实现
* @createDate 2024-11-05 14:35:23
*/
@Service
public class CHomeServiceImpl extends ServiceImpl<CHomeMapper, CHome>
    implements CHomeService {

    @Override
    public Page getHomeInfo(int page, int pageSize) {
        Page<CHome> pageInfo = new Page(page, pageSize);
        LambdaQueryWrapper<CHome> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        return this.page(pageInfo,lambdaQueryWrapper);
    }
}




