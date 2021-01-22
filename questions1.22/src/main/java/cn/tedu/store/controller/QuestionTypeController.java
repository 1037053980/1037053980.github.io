package cn.tedu.store.controller;

import cn.tedu.store.entity.QuestionType;
import cn.tedu.store.service.IQuestionTypeService;
import cn.tedu.store.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //等价于@Controller + @ReponseBody
//@RequestMapping注解，写在控制器类上，表示该类处理以指定url开头的所有请求
@RequestMapping("/que_type")
@Validated
public class QuestionTypeController extends BaseController{

    @Autowired
    private IQuestionTypeService questionTypeService;

    @PostMapping("/add_type")
    public R<Void> addToQueType(String title){
        questionTypeService.addToQueType(title);
        return new R<>(OK);
    }

    @GetMapping("/get_type_list")
    public R<List<QuestionType>> getAllTypes(){
        List<QuestionType> data = questionTypeService.getAllTypes();
        return new R<>(OK,data);
    }

}
