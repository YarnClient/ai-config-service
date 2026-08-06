package com.example.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用下拉选项模型。
 * 字段名遵循神策动态下拉参数规范：
 * name  = 下拉菜单显示名称
 * value = 选项值（必须唯一）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option {

    /** 选项值，传给下游 API */
    private String value;

    /** 下拉菜单显示名称 */
    private String name;
}
