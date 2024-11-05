package com.energy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName c_product
 */
@TableName(value ="c_product")
@Data
public class CProduct implements Serializable {
    private Long id;

    private Long scenarioId;

    private String url;

    private String title;

    private String content;

    private static final long serialVersionUID = 1L;
}