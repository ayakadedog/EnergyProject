package com.energy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.energy.entity.CHome;
import com.energy.entity.CPicture;
import com.energy.mapper.CPictureMapper;
import com.energy.service.CPictureService;
import com.energy.service.CProductService;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【c_picture】的数据库操作Service实现
* @createDate 2024-11-09 22:38:19
*/
@Service
public class CPictureServiceImpl extends ServiceImpl<CPictureMapper, CPicture>
    implements CPictureService {


    @Override
    public Page<CPicture> getHomeInfo(int page, int pageSize) {
        Page<CPicture> pageInfo = new Page(page, pageSize);
        LambdaQueryWrapper<CPicture> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        return this.page(pageInfo,lambdaQueryWrapper);
    }
}




