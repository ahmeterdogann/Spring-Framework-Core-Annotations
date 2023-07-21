package com.ahmeterdogan.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("autowiredBeans.xml");
        A a = (A) applicationContext.getBean("A");
        a.doB();
    }
}