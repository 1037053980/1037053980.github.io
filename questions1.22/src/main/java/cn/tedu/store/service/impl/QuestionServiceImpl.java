package cn.tedu.store.service.impl;

import cn.tedu.store.entity.Question;
import cn.tedu.store.entity.QuestionSolved;
import cn.tedu.store.entity.QuestionType;
import cn.tedu.store.mapper.QuestionMapper;
import cn.tedu.store.mapper.QuestionSolvedMapper;
import cn.tedu.store.mapper.QuestionTypeMapper;
import cn.tedu.store.service.IQuestionService;
import cn.tedu.store.service.IQuestionTypeService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.QuestionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    QuestionTypeMapper questionTypeMapper;

    @Autowired
    IQuestionTypeService questionTypeService;

    @Autowired
    QuestionSolvedMapper questionSolvedMapper;

    @Override
    public void addQuestion(Question question) {
        LocalDateTime now = LocalDateTime.now();
        String typeName = question.getTypeName();
        QuestionType result = questionTypeMapper.findByTitle(typeName);
        if(result == null){
            questionTypeService.addToQueType(typeName);
        }
        question.setGmtCreate(now);
        question.setGmtModified(now);
        Integer re = questionMapper.insert(question);
        if(re != 1) {
            throw new InsertException("系统繁忙，请稍后再试");
        }
    }

    @Override
    public List<Question> getQuestionByTypeName(String typeName) {
        List<Question> list = questionMapper.findQuestionsByTypeName(typeName);
        if(list.isEmpty()){
            throw new QuestionNotFoundException("没有此类的问题");
        }
        return list;
    }

    @Override
    public Question getQuestionById(Integer id) {
        Question question = questionMapper.findQuestionById(id);
        if( question == null){
            throw new QuestionNotFoundException("该问题未找到");
        }
        return question;
    }

    @Override
    public Question getQuestionUnsolved(String typeName, Integer uid) {
        List<Question> list = getQuestionByTypeName(typeName);
        List<QuestionSolved> questionSolveds = questionSolvedMapper.findByUid(uid);
        for (Question now : list) {
            Integer flag = 1;
            for (QuestionSolved questionSolved : questionSolveds) {
                if(now.getId() == questionSolved.getQid()){
                    flag = 0;
                    break;
                }
            }
            if(flag == 1) return now;
        }
        return null;
    }
}
