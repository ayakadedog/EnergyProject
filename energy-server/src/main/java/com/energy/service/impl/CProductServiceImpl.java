package com.energy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.energy.entity.CProduct;
import com.energy.mapper.CProductMapper;
import com.energy.service.CProductService;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【c_product(产品表)】的数据库操作Service实现
* @createDate 2024-11-05 14:35:23
*/
@Service
public class CProductServiceImpl extends ServiceImpl<CProductMapper, CProduct>
    implements CProductService {

}



