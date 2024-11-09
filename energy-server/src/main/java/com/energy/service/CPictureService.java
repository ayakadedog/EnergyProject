package com.energy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.energy.entity.CPicture;
import com.energy.entity.CProduct;

/**
* @author lenovo
* @description 针对表【c_picture】的数据库操作Service
* @createDate 2024-11-09 22:38:19
*/
public interface CPictureService extends IService<CPicture> {

    Page<CPicture> getHomeInfo(int page, int pageSize);
}
