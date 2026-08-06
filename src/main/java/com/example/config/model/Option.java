package com.example.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 通用下拉选项模型
 */
@Data
@AllArgsConstructor
public class Option {

    /** 参数值，传给下游 API */
    private String value;

    /** 显示文本，前端下拉展示 */
    private String label;
}
