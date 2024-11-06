package com.energy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName c_comment
 */
@TableName(value ="c_comment")
@Data
public class CComment implements Serializable {
    private Long id;

    private String content;

    private String phone;

    private String email;

    private Date createTime;

    private String name;

    private static final long serialVersionUID = 1L;
}