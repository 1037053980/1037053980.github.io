package cn.tedu.store.mapper;

import cn.tedu.store.entity.QuestionType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QuestionTypeMapperTests {

    @Autowired
    QuestionTypeMapper questionTypeMapper;

    @Test
    void insert(){
        LocalDateTime now = LocalDateTime.now();
        QuestionType questionType = new QuestionType();
        questionType.setTitle("离散数学");
        questionType.setGmtCreate(now);
        questionType.setGmtModified(now);
        Integer result = questionTypeMapper.insert(questionType);
        System.out.println(result);
    }

    @Test
    void findById(){
        Integer id = 1;
        QuestionType result = questionTypeMapper.findById(id);
        System.out.println(result);
    }

    @Test
    void findAllTypes(){
        List<QuestionType> allTypes = questionTypeMapper.findAllTypes();
        for (QuestionType allType : allTypes) {
            System.out.println(allType);
        }
    }

    @Test
    void findByTitle(){
        QuestionType re = questionTypeMapper.findByTitle("数据结构");
        System.out.println(re);
    }
}
