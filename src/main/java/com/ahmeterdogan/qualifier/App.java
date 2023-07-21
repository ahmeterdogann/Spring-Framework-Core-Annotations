package com.ahmeterdogan.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("qualifierBeans.xml");
        A a = (A) applicationContext.getBean("a");
        a.doSth();
    }
}
