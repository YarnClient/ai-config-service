package com.example.config.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * AI Agent / 话术模板 模型。
 * 字段名遵循神策动态下拉参数规范：
 * name  = 下拉菜单显示名称
 * value = 选项值
 * detail.description = 信息卡片描述
 */
@Data
public class Agent {

    /** 模板/Agent ID，序列化为 "value" */
    @JsonProperty("value")
    private String id;

    /** 名称，序列化为 "name" */
    private String name;

    /** 描述，嵌套在 detail.description 中序列化 */
    @JsonIgnore
    private String description;

    /**
     * 按神策规范序列化为 detail 对象，用于展示信息卡片
     */
    @JsonProperty("detail")
    public Map<String, String> getDetail() {
        if (description == null || description.isEmpty()) {
            return null;
        }
        Map<String, String> detail = new LinkedHashMap<>();
        detail.put("description", description);
        return detail;
    }
}
