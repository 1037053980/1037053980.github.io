package cn.tedu.store.vo;

import cn.tedu.store.entity.Question;

public class QuestionJudgeVO {
    private Question question;
    private Integer result;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "questionJudgeVO{" +
                "question=" + question +
                ", result=" + result +
                '}';
    }
}
