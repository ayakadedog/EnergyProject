package com.energy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.energy.entity.CHome;
import com.baomidou.mybatisplus.extension.service.IService;
import com.energy.result.Result;

import java.util.List;

/**
* @author lenovo
* @description 针对表【c_home】的数据库操作Service
* @createDate 2024-11-05 14:35:23
*/
public interface CHomeService extends IService<CHome> {

    Page getHomeInfo(int page, int pageSize);
}
