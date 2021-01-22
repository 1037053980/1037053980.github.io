package cn.tedu.store.service;

import cn.tedu.store.entity.QuestionType;

import java.util.List;

/**
 * 问题类型业务层接口
 */
public interface IQuestionTypeService {

    /**
     *
     * @param queType
     */
    void addToQueType(String queType);

    /**
     *
     * @param id
     * @return
     */
    QuestionType getTypeById(Integer id);

    /**
     *
     * @return
     */
    List<QuestionType> getAllTypes();

    /**
     *
     * @param title
     * @return
     */
    QuestionType getTypeByTitle(String title);
}
