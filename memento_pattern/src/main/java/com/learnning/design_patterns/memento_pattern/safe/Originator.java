package com.learnning.design_patterns.memento_pattern.safe;

/**
 * 类 名 称：Originator.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月17日
 */
public class Originator {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public IMemento createMemento() {
        return new Memento(status);
    }

    public void restoreMemento(IMemento memento) {
        setStatus(((Memento) memento).getStatus());
    }

    class Memento implements IMemento {

        private String status;

        private Memento(String status) {
            this.status = status;
        }

        private String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
