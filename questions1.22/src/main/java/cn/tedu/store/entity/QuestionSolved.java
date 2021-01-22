package cn.tedu.store.entity;

import java.time.LocalDateTime;

public class QuestionSolved {
    private Integer id;
    private Integer uid;
    private Integer qid;
    private Integer acOrWo;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public Integer getAcOrWo() {
        return acOrWo;
    }

    public void setAcOrWo(Integer acOrWo) {
        this.acOrWo = acOrWo;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "QuestionSolved{" +
                "id=" + id +
                ", uid=" + uid +
                ", qid=" + qid +
                ", acOrWo=" + acOrWo +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
