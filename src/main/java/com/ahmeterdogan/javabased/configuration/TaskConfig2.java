package com.ahmeterdogan.javabased.configuration;

import com.ahmeterdogan.javabased.component.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class TaskConfig2 {
    @Bean("testerTask")
    public Task getTesterTask() {
        return new Task(3, LocalDate.of(2023, 7, 28), 10);
    }

    @Bean("developerTask")
    public Task getDeveloperTask() {
        return new Task(4, LocalDate.of(2023, 8, 1), 15);
    }
}
