package com.ahmeterdogan.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("primaryBeans.xml");
        A a = (A) applicationContext.getBean("a");
        a.doSth();
    }
}
