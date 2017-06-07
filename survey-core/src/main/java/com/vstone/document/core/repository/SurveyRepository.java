package com.vstone.document.core.repository;

import com.vstone.document.api.domain.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public interface SurveyRepository extends MongoRepository<Survey, String> {

    Survey findByIdAndCode(String id, String code);

    Survey findByCodeAndValid(String code, boolean valid);

    List<Survey> findByCode(String code);

    List<Survey> findByValid(boolean valid);
}
