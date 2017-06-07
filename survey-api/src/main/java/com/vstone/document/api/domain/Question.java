package com.vstone.document.api.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * 问题 不存在真正意义的修改
 */
@Data
public class Question {

    private String code; // 修改的时候不会变

    private int order;
    private String question;
    private String remark;
    private String answers;

    @Field(value = "option_list")
    private List<Option> optionList;
}
