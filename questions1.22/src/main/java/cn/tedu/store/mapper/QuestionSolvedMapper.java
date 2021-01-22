package cn.tedu.store.mapper;

import cn.tedu.store.entity.QuestionSolved;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionSolvedMapper {

    Integer insert(QuestionSolved questionSolved);

    List<QuestionSolved> findByUid(Integer uid);
}
