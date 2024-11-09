package com.energy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName c_picture
 */
@TableName(value ="c_picture")
@Data
public class CPicture implements Serializable {
    private Long id;

    private String name;

    private String picture;

    private String content;

    private String title;
    private static final long serialVersionUID = 1L;
}