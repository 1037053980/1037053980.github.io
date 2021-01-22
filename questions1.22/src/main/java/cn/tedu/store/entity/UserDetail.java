package cn.tedu.store.entity;

import java.time.LocalDateTime;

public class UserDetail {
    private Integer id;
    private Integer uid;
    private Integer solvedTotal;
    private Integer acTotal;
    private Integer woTotal;
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

    public Integer getSolvedTotal() {
        return solvedTotal;
    }

    public void setSolvedTotal(Integer solvedTotal) {
        this.solvedTotal = solvedTotal;
    }

    public Integer getAcTotal() {
        return acTotal;
    }

    public void setAcTotal(Integer acTotal) {
        this.acTotal = acTotal;
    }

    public Integer getWoTotal() {
        return woTotal;
    }

    public void setWoTotal(Integer woTotal) {
        this.woTotal = woTotal;
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
        return "UserDetail{" +
                "id=" + id +
                ", uid=" + uid +
                ", solvedTotal=" + solvedTotal +
                ", acTotal=" + acTotal +
                ", woTotal=" + woTotal +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
