package com.ahmeterdogan.profile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.stereotype.Component;

@Component
public class A {
    private IDatabase database;

    @Autowired
    public A(IDatabase database) {
        this.database = database;
    }

    public void connectDatabase() {
        database.crud();
    }
}

@Component
@Profile("prod")
class ProdDatabase implements IDatabase {

    @Override
    public void crud() {
        System.out.println("Prod Database");
    }
}

@Component
@Profile("test")
class TestDatabase implements IDatabase {

    @Override
    public void crud() {
        System.out.println("Test Database");
    }
}

interface IDatabase {
    void crud();
}

class App {
    public static void main(String[] args) {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "test");
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("profileBeans.xml");
        A a1 = (A) applicationContext1.getBean("a");
        a1.connectDatabase();

        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("profileBeans.xml");
        A a2 = (A) applicationContext2.getBean("a");

        a2.connectDatabase();
    }
}