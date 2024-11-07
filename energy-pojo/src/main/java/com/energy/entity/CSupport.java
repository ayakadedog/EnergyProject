package com.energy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "c_support")
@Data
public class CSupport {

    private Long id;

    private String title;

    private String content;

    private String url;

    private String category;

    private static final long serialVersionUID = 1L;

}
