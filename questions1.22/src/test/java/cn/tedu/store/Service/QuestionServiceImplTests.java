package cn.tedu.store.Service;

import cn.tedu.store.entity.Question;
import cn.tedu.store.service.IQuestionService;
import cn.tedu.store.service.IQuestionTypeService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.QuestionNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QuestionServiceImplTests {
    @Autowired
    private IQuestionService questionService;

    @Test
    void addQuestion(){
        LocalDateTime now = LocalDateTime.now();
        Question question = new Question();
        question.setTitle("电视卡");
        question.setAnswer1("A");
        question.setAnswer2("B");
        question.setAnswer3("C");
        question.setAnswer4("D");
        question.setCorrect(1);
        question.setTypeId(1);
        question.setTypeName("材料力学");
        question.setGmtCreate(now);
        question.setGmtModified(now);
        try {
            questionService.addQuestion(question);
        }catch (InsertException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getQuestionByTypeName(){
        String name = "数据结";
        try {
            List<Question> questionList = questionService.getQuestionByTypeName(name);
            for (Question question : questionList) {
                System.out.println(question);
            }
        }catch (QuestionNotFoundException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getQuestionById(){
        Integer id = 6;
        try {
            Question question = questionService.getQuestionById(id);
            System.out.println(question);
        }catch (QuestionNotFoundException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
