package com.example.config.model;

import lombok.Data;

/**
 * AI Agent / 话术模板 模型
 */
@Data
public class Agent {

    /** 模板/Agent ID，传给下游 API */
    private String id;

    /** 名称 */
    private String name;

    /** 描述 */
    private String description;
}
