package com.example.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AI Agent / 话术模板 模型。
 * 字段名直接对应神策动态下拉参数规范：
 * name  = 下拉菜单显示名称
 * value = 选项值
 * detail.description = 信息卡片描述
 */
@Data
@NoArgsConstructor
public class Agent {

    /** 选项值（模板/Agent ID，传给下游 API） */
    private String value;

    /** 下拉菜单显示名称 */
    private String name;

    /** 信息卡片 */
    private Detail detail;

    /** 便捷构造 */
    public Agent(String value, String name, String description) {
        this.value = value;
        this.name = name;
        this.detail = new Detail(description);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Detail {
        private String description;
    }
}
