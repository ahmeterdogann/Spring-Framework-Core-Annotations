package com.ahmeterdogan.javabased.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Tester implements Worker {
    private Task testerTask;

    @Autowired
    public Tester(@Qualifier("testerTask")Task testerTask) {
        this.testerTask = testerTask;
    }


    @Override
    public void work() {
        System.out.println("Tester task : " + testerTask);
    }
}
