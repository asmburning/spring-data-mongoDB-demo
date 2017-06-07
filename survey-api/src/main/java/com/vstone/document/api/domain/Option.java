package com.vstone.document.api.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * 选项
 */
@Data
public class Option {
    @Field(value = "question_code")
    private String questionCode; // 关联question
    private int order;
    @Field(value = "option_name")
    private String optionName;
    @Field(value = "option_value")
    private String optionValue;
    private BigDecimal weight; // 权重
}
