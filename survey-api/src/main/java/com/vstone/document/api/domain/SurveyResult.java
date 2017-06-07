package com.vstone.document.api.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

/**
 * 用户提交的问卷结果,关联用户Id,surveyId,以及问题的答案
 */
@Data
@Document(collection = "surveyResult")
@CompoundIndexes({
        @CompoundIndex(name = "idx_svyR_userCodeValid",def = "{'userId':1,'surveyCode':1,'valid':1}")
})
public class SurveyResult {
    private String id;
    private String userId;
    private boolean valid = true;
    private String surveyCode; // 确定问卷调查的业务类型
    private String surveyId; // 确定问卷调查的版本号
    private Date createTime; // 提交问卷的时间
    private Set<QuestionAnswer> questionAnswerSet;
}
