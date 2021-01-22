package cn.tedu.store.service;

import cn.tedu.store.entity.Question;
import cn.tedu.store.vo.QuestionJudgeVO;

public interface IJudgeService {

    QuestionJudgeVO questionJudge(Integer qid, Integer select, Integer uid);

}
