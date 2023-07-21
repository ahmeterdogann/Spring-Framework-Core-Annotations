package com.ahmeterdogan.javabased.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Office {
    private List<Worker> workers;

    @Autowired
    public Office(List<Worker> workers) {
        this.workers = workers;
    }

    public void work() {
        workers.forEach(System.out::println);
        workers.forEach(Worker::work);
    }
}
