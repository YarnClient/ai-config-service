package com.example.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 呼叫路由模型
 */
@Data
@AllArgsConstructor
public class Route {

    /** 路由 ID，传给下游 API */
    private String id;

    /** 路由名称 */
    private String name;

    /** 路由描述 */
    private String description;
}
