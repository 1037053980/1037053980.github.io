package cn.tedu.store.mapper;

import cn.tedu.store.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    Integer insert(Question question);

    List<Question> findQuestionsByTypeName(String typeName);

    Question findQuestionById(Integer id);
}
