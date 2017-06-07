package com.vstone.document.core.service;

import com.vstone.document.api.domain.Survey;
import com.vstone.document.api.domain.SurveyResult;
import com.vstone.document.core.repository.SurveyRepository;
import com.vstone.document.core.repository.SurveyResultRepository;
import com.vstone.document.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 问卷服务
 */
@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private SurveyResultRepository surveyResultRepository;

    @Override
    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey findOne(String id) {
        return surveyRepository.findOne(id);
    }

    @Override
    public Survey findByIdAndCode(String id, String code) {
        return surveyRepository.findByIdAndCode(id, code);
    }

    @Override
    public Survey findValidByCode(String surveyCode) {
        return surveyRepository.findByCodeAndValid(surveyCode, true);
    }

    @Override
    public List<Survey> findAllByCode(String surveyCode) {
        return surveyRepository.findByCode(surveyCode);
    }

    @Override
    public List<Survey> findAllValid() {
        return surveyRepository.findByValid(true);
    }

    @Override
    public void saveSurvey(Survey survey) {
        Survey old = surveyRepository.findByCodeAndValid(survey.getCode(), true);
        if (null != old) {
            old.setValid(false);
            surveyRepository.save(old);
        }
        survey.setValid(true);
        survey.setId(IdUtil.nextId());
        survey.setCreateTime(new Date());
        surveyRepository.save(survey);
    }

    @Override
    public void saveResult(SurveyResult surveyResult) {
        SurveyResult oldResult = surveyResultRepository.findByUserIdAndSurveyCodeAndValid(surveyResult.getUserId(), surveyResult.getSurveyCode(), true);
        if (null != oldResult) {
            oldResult.setValid(false);
            surveyResultRepository.save(oldResult);
        }
        surveyResultRepository.save(surveyResult);
    }

    @Override
    public SurveyResult findUserValidResultByCode(String userId, String surveyCode) {
        return surveyResultRepository.findByUserIdAndSurveyCodeAndValid(userId, surveyCode, true);
    }

    @Override
    public List<SurveyResult> findUserResultsByCode(String userId, String surveyCode) {
        return surveyResultRepository.findByUserIdAndSurveyCode(userId, surveyCode);
    }
}
