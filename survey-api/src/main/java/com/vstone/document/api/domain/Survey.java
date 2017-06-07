package com.vstone.document.api.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * 调查问卷,包含一系列的问题
 */
@Data
@Document(collection = "survey")
@CompoundIndexes({
        @CompoundIndex(name = "idx_svy_codeValid", def = "{'code':1,'valid':1}")
})
public class Survey {
    private String id; // 用来记录版本号
    private String code; // 用来区分业务类型
    private boolean valid = true; // 历史版本记录为 false 当前版本为 true
    @Field(value = "create_time")
    private Date createTime;// 创建时间
    private String title;
    private String remark;
    @Field(value = "question_list")
    private List<Question> questionList;
}
