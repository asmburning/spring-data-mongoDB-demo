package com.vstone.document.core.controller;

import com.vstone.document.api.domain.Option;
import com.vstone.document.api.domain.Question;
import com.vstone.document.api.domain.Survey;
import com.vstone.document.core.service.SurveyService;
import com.vstone.document.core.util.IdUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 问卷controller
 */
@RestController
@Log4j2
@RequestMapping(value = "/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping(value = "/testSave")
    public Survey testSave() {
        Survey survey = new Survey();
        // survey.setId(IdUtil.nextId());
        survey.setCode("orgRisk");
        survey.setCreateTime(new Date());
        survey.setTitle("机构风险测评问卷");
        survey.setRemark("remark");

        List<Question> questionList = new ArrayList<>();
        questionList.add(getQuestion1());
        questionList.add(getQuestion2());

        survey.setQuestionList(questionList);
        surveyService.saveSurvey(survey);
        return survey;
    }

    private Question getQuestion1() {
        Question question = new Question();
        String questionCode = IdUtil.nextId();
        question.setCode(questionCode);
        question.setQuestion("1, 2+3=?");
        question.setOrder(1);
        question.setRemark("1254");
        List<Option> optionList = new ArrayList<>();
        Option a = new Option();
        a.setOrder(1);
        a.setOptionName("A");
        a.setOptionValue("4");
        a.setQuestionCode(questionCode);
        a.setWeight(new BigDecimal("2.1"));
        Option b = new Option();
        b.setOrder(2);
        b.setOptionName("B");
        b.setOptionValue("5");
        b.setQuestionCode(questionCode);
        b.setWeight(new BigDecimal("2.1"));
        Option c = new Option();
        c.setOrder(3);
        c.setOptionName("C");
        c.setOptionValue("6");
        c.setQuestionCode(questionCode);
        c.setWeight(new BigDecimal("2.1"));
        Option d = new Option();
        d.setOrder(4);
        d.setOptionName("D");
        d.setOptionValue("7");
        d.setQuestionCode(questionCode);
        d.setWeight(new BigDecimal("2.1"));
        optionList.add(a);
        optionList.add(b);
        optionList.add(c);
        optionList.add(d);
        question.setOptionList(optionList);
        return question;
    }

    private Question getQuestion2() {
        Question question = new Question();
        String questionCode = IdUtil.nextId();
        question.setCode(questionCode);
        question.setQuestion("2, 2*3=?");
        question.setOrder(2);
        question.setRemark("339966");
        List<Option> optionList = new ArrayList<>();
        Option a = new Option();
        a.setOrder(1);
        a.setOptionName("A");
        a.setOptionValue("4");
        a.setQuestionCode(questionCode);
        a.setWeight(new BigDecimal("2.8"));
        Option b = new Option();
        b.setOrder(2);
        b.setOptionName("B");
        b.setOptionValue("5");
        b.setQuestionCode(questionCode);
        b.setWeight(new BigDecimal("2.1"));
        Option c = new Option();
        c.setOrder(3);
        c.setOptionName("C");
        c.setOptionValue("6");
        c.setQuestionCode(questionCode);
        c.setWeight(new BigDecimal("2.2"));
        Option d = new Option();
        d.setOrder(4);
        d.setOptionName("D");
        d.setOptionValue("7");
        d.setQuestionCode(questionCode);
        d.setWeight(new BigDecimal("2.3"));
        optionList.add(a);
        optionList.add(b);
        optionList.add(c);
        optionList.add(d);

        question.setOptionList(optionList);
        return question;
    }

    @GetMapping(value = "/findById")
    public Survey getById(@RequestParam String id) {
        Survey survey = surveyService.findOne(id);
        return survey;
    }

    @GetMapping(value = "/getAll")
    public List<Survey> getAll() {
        List<Survey> surveyList = surveyService.findAll();
        return surveyList;
    }

    @GetMapping(value = "/getByCode")
    public List<Survey> findAllByCode() {
        List<Survey> surveyList = surveyService.findAllByCode("orgRisk");
        return surveyList;
    }

    @GetMapping(value = "/findValidByCode")
    public Survey getById() {
        Survey survey = surveyService.findValidByCode("orgRisk");
        return survey;
    }
}
