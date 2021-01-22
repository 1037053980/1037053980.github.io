package cn.tedu.store.service.impl;

import cn.tedu.store.entity.Question;
import cn.tedu.store.entity.QuestionSolved;
import cn.tedu.store.entity.UserDetail;
import cn.tedu.store.mapper.QuestionSolvedMapper;
import cn.tedu.store.service.IJudgeService;
import cn.tedu.store.service.IQuestionService;
import cn.tedu.store.service.IUserDetailService;
import cn.tedu.store.service.ex.QuestionNotFoundException;
import cn.tedu.store.vo.QuestionJudgeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JudgeServiceImpl implements IJudgeService {
    @Autowired
    private IQuestionService questionService;

    @Autowired
    private QuestionSolvedMapper questionSolvedMapper;

    @Autowired
    private IUserDetailService userDetailService;

    @Override
    public QuestionJudgeVO questionJudge(Integer qid, Integer select, Integer uid) {
       // System.out.println(select);
        LocalDateTime now = LocalDateTime.now();
        QuestionSolved questionSolved = new QuestionSolved();

        QuestionJudgeVO questionJudgeVO = new QuestionJudgeVO();
        Question question = questionService.getQuestionById(qid);
        if(question == null) throw new QuestionNotFoundException("没有该问题");
        Integer answer = question.getCorrect();
        //添加已做题
        questionSolved.setUid(uid);
        questionSolved.setQid(qid);
        questionSolved.setGmtCreate(now);
        questionSolved.setGmtModified(now);

        //更新用户错题信息
        UserDetail userDetail = new UserDetail();
        UserDetail userDetailByUid = userDetailService.getUserDetailByUid(uid);
        userDetailByUid.setGmtModified(now);
        Integer ac = userDetailByUid.getAcTotal();
        Integer wo = userDetailByUid.getWoTotal();
        Integer total = userDetailByUid.getSolvedTotal();
        total += 1;

        if(answer == select ){
            questionJudgeVO.setQuestion(question);
            questionJudgeVO.setResult(1);
            questionSolved.setAcOrWo(1);
            ac += 1;
        }
        else{
            questionJudgeVO.setQuestion(question);
            questionJudgeVO.setResult(0);
            questionSolved.setAcOrWo(0);
            wo += 1;
        }
        questionSolvedMapper.insert(questionSolved);

        userDetailByUid.setSolvedTotal(total);
        userDetailByUid.setAcTotal(ac);
        userDetailByUid.setWoTotal(wo);
        userDetailService.updateUserDetailByUid(userDetailByUid);

        return questionJudgeVO;
    }
}
