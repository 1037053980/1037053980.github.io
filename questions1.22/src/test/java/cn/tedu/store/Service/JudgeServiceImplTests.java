package cn.tedu.store.Service;

import cn.tedu.store.service.IJudgeService;
import cn.tedu.store.vo.QuestionJudgeVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JudgeServiceImplTests {

    @Autowired
    private IJudgeService judgeService;

    @Test
    void questionJudge(){
        Integer queId = 5;
        Integer select = 2;
        Integer uid = 3;
        QuestionJudgeVO judgeVO = judgeService.questionJudge(queId, select,uid);
        System.out.println(judgeVO);
    }
}
