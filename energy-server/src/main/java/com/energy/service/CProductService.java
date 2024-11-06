package com.energy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.energy.entity.CProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lenovo
* @description 针对表【c_product(产品表)】的数据库操作Service
* @createDate 2024-11-05 14:35:23
*/
public interface CProductService extends IService<CProduct> {

    void modifyStatus(Integer stu, List<Long> ids);

    Page<CProduct> getPage(Integer page, Integer pageSize, String name);

    List<CProduct> orderByType(String type);
}
