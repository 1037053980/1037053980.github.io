package cn.tedu.store.service;

import cn.tedu.store.entity.Question;

import java.util.List;

public interface IQuestionService {

    void addQuestion(Question question);

    List<Question> getQuestionByTypeName(String typeName);

    Question getQuestionById(Integer id);

    Question getQuestionUnsolved(String typeName, Integer uid);
}
