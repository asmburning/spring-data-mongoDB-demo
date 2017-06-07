package com.vstone.document.core.repository;

import com.vstone.document.api.domain.SurveyResult;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public interface SurveyResultRepository
        extends MongoRepository<SurveyResult, String> {

    SurveyResult findByUserIdAndSurveyCodeAndValid(String userId,String surveyCode,boolean valid);

    List<SurveyResult> findByUserIdAndSurveyCode(String userId,String surveyCode);
}
