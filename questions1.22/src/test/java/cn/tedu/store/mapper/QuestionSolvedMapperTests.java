package cn.tedu.store.mapper;

import cn.tedu.store.entity.QuestionSolved;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QuestionSolvedMapperTests {

    @Autowired
    QuestionSolvedMapper questionSolvedMapper;

    @Test
    void insert(){
        LocalDateTime now = LocalDateTime.now();
        QuestionSolved questionSolved = new QuestionSolved();
        questionSolved.setQid(2);
        questionSolved.setUid(1);
        questionSolved.setAcOrWo(1);
        questionSolved.setGmtCreate(now);
        questionSolved.setGmtModified(now);
        Integer re = questionSolvedMapper.insert(questionSolved);
        System.out.println(re);
    }

    @Test
    void findByUid(){
        Integer uid = 1;
        List<QuestionSolved> list = questionSolvedMapper.findByUid(uid);
        for (QuestionSolved questionSolved : list) {
            System.out.println(questionSolved);
        }
    }
}
