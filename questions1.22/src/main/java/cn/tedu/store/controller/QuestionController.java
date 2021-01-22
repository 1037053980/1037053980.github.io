package cn.tedu.store.controller;

import cn.tedu.store.entity.Question;
import cn.tedu.store.service.IJudgeService;
import cn.tedu.store.service.IQuestionService;
import cn.tedu.store.util.R;
import cn.tedu.store.vo.QuestionJudgeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController //等价于@Controller + @ReponseBody
//@RequestMapping注解，写在控制器类上，表示该类处理以指定url开头的所有请求
@RequestMapping("/question")
@Validated
public class QuestionController extends BaseController{

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IJudgeService judgeService;

    @PostMapping("/add_question")
    public R<Void> addToQuestion(Question question){
        questionService.addQuestion(question);
        return new R<>(OK);
    }

    @GetMapping("/get_question_by_type")
    public R<List<Question>> getQuestionByType(String type){
        List<Question> data = questionService.getQuestionByTypeName(type);
        return new R<>(OK,data);
    }

    @GetMapping("/get_question_by_id")
    public R<Question> getQuestionById(Integer id){
        Question data = questionService.getQuestionById(id);
        return new R<>(OK,data);
    }

    @PostMapping("/judge")
    public R<QuestionJudgeVO> judge(Integer qid, Integer select, HttpSession session){
        Integer id = getUidFromSession(session);
        QuestionJudgeVO data = judgeService.questionJudge(qid,select,id);
        return new R<>(OK,data);
    }

    @GetMapping("/get_question_unsolved")
    public R<Question> getQuestionUnsolved(String type, HttpSession session){
        Integer id = getUidFromSession(session);
        Question data = questionService.getQuestionUnsolved(type,id);
        return new R<>(OK,data);
    }
}
