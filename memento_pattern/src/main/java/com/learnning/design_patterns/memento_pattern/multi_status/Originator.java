package com.learnning.design_patterns.memento_pattern.multi_status;


/**
 * 类 名 称：Originator.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月17日
 */
public class Originator {
    private String status1;
    private String status2;
    private String status3;

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public String getStatus3() {
        return status3;
    }

    public void setStatus3(String status3) {
        this.status3 = status3;
    }

    public Memento CreateMements() {
        return new Memento(BeanUtils.backupProp(this));
    }

    public void restoreMemento(Memento memento) {
        BeanUtils.restoreProp(this, memento.getStatusMap());
    }

    @Override
    public String toString() {
        return "status1=" + status1 + "，status2=" + status2 + "，status3=" + status3;
    }
}
