package cn.tedu.store.mapper;

import cn.tedu.store.entity.QuestionType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 问题分类的持久层接口
 */
@Mapper
public interface QuestionTypeMapper {

    /**
     *
     * @param questionType
     * @return
     */
    Integer insert(QuestionType questionType);

    /**
     *
     * @param id
     * @return
     */
    QuestionType findById(Integer id);

    /**
     *
     * @param id
     * @return
     */
    QuestionType findByTitle(String title);

    /**
     *
     * @return
     */
    List<QuestionType> findAllTypes();

}
