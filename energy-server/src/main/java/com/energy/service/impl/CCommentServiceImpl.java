package com.energy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.energy.entity.CComment;

import com.energy.mapper.CCommentMapper;
import com.energy.service.CCommentService;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【c_comment】的数据库操作Service实现
* @createDate 2024-11-05 14:35:23
*/
@Service
public class CCommentServiceImpl extends ServiceImpl<CCommentMapper, CComment>
    implements CCommentService {

}




