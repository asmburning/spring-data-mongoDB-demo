package com.vstone.document.core.service;

import com.vstone.document.api.domain.Survey;
import com.vstone.document.api.domain.SurveyResult;

import java.util.List;

/**
 * 问卷服务
 */
public interface SurveyService {



    List<Survey> findAll();

    Survey findOne(String id);

    /**
     * @param id
     * @param code
     * @return
     */
    Survey findByIdAndCode(String id, String code);

    /**
     * 获取最新版本的survey
     *
     * @param surveyCode
     * @return
     */
    Survey findValidByCode(String surveyCode);

    /**
     * 通过code获取survey历史记录
     *
     * @param surveyCode
     * @return
     */
    List<Survey> findAllByCode(String surveyCode);

    /**
     * 获取有效的问卷列表
     *
     * @return
     */
    List<Survey> findAllValid();

    /**
     * 创建或更新survey
     *
     * @param survey
     */
    void saveSurvey(Survey survey);

    /**
     * 保存问卷调查结果
     *
     * @param surveyResult
     */
    void saveResult(SurveyResult surveyResult);

    /**
     * 获取用户最新问卷调查结果
     *
     * @param userId
     * @param surveyCode
     * @return
     */
    SurveyResult findUserValidResultByCode(String userId, String surveyCode);

    List<SurveyResult> findUserResultsByCode(String userId,String surveyCode);
}
