package com.energy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * @TableName c_scenario
 */
@TableName(value ="c_scenario")
@Data
public class CScenario implements Serializable {
    private Long id;

    private String title;

    private String content;

    private String url;

    private Integer status;

    private String picture;

    private LocalDateTime createTime;

    private static final long serialVersionUID = 1L;
}