package cn.tedu.store.mapper;

import cn.tedu.store.entity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QuestionMapperTests {

    @Autowired
    private QuestionMapper questionMapper;

    @Test
    void insert(){
        LocalDateTime now = LocalDateTime.now();
        Question question = new Question();
        question.setTitle("考");
        question.setAnswer1("A");
        question.setAnswer2("B");
        question.setAnswer3("C");
        question.setAnswer4("D");
        question.setCorrect(1);
        question.setTypeId(1);
        question.setTypeName("数据结构");
        question.setGmtCreate(now);
        question.setGmtModified(now);
        questionMapper.insert(question);
    }

    @Test
    void findQuestionsByTypeName(){
        String typeName = "数据构";
        List<Question> questionsByTypeId = questionMapper.findQuestionsByTypeName(typeName);
        for (Question question : questionsByTypeId) {
            System.out.println(question);
        }
    }

    @Test
    void findQuestionById(){
        Integer id = 3;
        Question questionById = questionMapper.findQuestionById(id);
        System.out.println(questionById);
    }
}
