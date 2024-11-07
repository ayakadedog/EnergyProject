package com.energy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.energy.entity.CSupport;
import com.energy.mapper.CSupportMapper;
import com.energy.service.CSupportService;
import org.springframework.stereotype.Service;

@Service
public class CSupportServiceImpl extends ServiceImpl<CSupportMapper, CSupport>
        implements CSupportService {
}
