package com.energy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName c_home
 */
@TableName(value ="c_home")
@Data
public class CHome implements Serializable {
    private Long id;

    private String url;

    private static final long serialVersionUID = 1L;
}