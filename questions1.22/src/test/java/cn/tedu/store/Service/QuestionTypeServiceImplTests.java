package cn.tedu.store.Service;

import cn.tedu.store.entity.QuestionType;
import cn.tedu.store.service.IQuestionTypeService;
import cn.tedu.store.service.ex.QuestionTypeDuplicateException;
import cn.tedu.store.service.ex.QuestionTypeNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QuestionTypeServiceImplTests {
    @Autowired
    private IQuestionTypeService questionTypeService;

    @Test
    void addToQueType(){
        try{
            questionTypeService.addToQueType("高数");
        }catch (QuestionTypeDuplicateException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }

    }

    @Test
    void getTypeByTitle(){
        String title = "数据结";
        try {
            QuestionType typeByTitle = questionTypeService.getTypeByTitle(title);
            System.out.println(typeByTitle);
        }catch (QuestionTypeNotFoundException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getAllTypes(){
        List<QuestionType> allTypes = questionTypeService.getAllTypes();
        for (QuestionType allType : allTypes) {
            System.out.println(allType);
        }
    }

    @Test
    void getTypeById(){
        Integer id = 4;
        try{
            QuestionType result = questionTypeService.getTypeById(id);
            System.out.println(result);
        }catch (QuestionTypeNotFoundException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
