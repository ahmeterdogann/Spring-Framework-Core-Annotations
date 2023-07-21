package com.ahmeterdogan.javabased.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Developer implements Worker {
    private Task developerTask;

    @Autowired
    public Developer(@Qualifier("developerTask") Task developerTask) {
        this.developerTask = developerTask;
    }

    @Override
    public void work() {
        System.out.println("Developer task : " + developerTask);
    }
}
