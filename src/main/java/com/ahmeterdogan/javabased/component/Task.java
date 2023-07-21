package com.ahmeterdogan.javabased.component;

import java.time.LocalDate;

public class Task {
    private int id;
    private LocalDate deadLine;
    private int sp;

    public Task(int id, LocalDate deadLine, int sp) {
        this.id = id;
        this.deadLine = deadLine;
        this.sp = sp;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    @Override
    public String toString() {
        return String.format("Task id : %d, deadline %s, sp : %d", id, deadLine.toString(), sp);
    }
}
