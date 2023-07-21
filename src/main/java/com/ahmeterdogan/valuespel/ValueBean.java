package com.ahmeterdogan.valuespel;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@PropertySource("file:/Users/ahmeterdog4n/Desktop/MySpace/IT/IdeaProjects/SpringFrameworkAnnotations/propfiles/probfile1") //BURDA DOSYA KONUMUNU JVM BAŞLATILIRKEN RUNTIME'DAN DA VEREBİLİRSİN
public class ValueBean {
    @Value("5")
    private int val;
    @Value("#{systemProperties}")
    private Map<String, String > systemProperties;
    @Value("#{systemProperties['java.version']}")
    private String systemJavaVersion;
    @Value("#{systemProperties['os.name']}")
    private String systemOs;

    @Value("${name}")
    private String ahmet;
    @Value("${pi}")
    private double pi;


    @Value("${xmlname}")
    private String xmlName;
    @Value("${xmlDouble}")
    private double xmlDouble;

    @Value("#{b.beanBField}")
    private String beanBField;

    @Value("${defaultValue:600}")
    private String defaultValue;

    public Map<String, String> getSystemProperties() {
        return systemProperties;
    }

    @Override
    public String toString() {
        return "ValueBean{" +
                "val=" + val +
                ", systemJavaVersion='" + systemJavaVersion + '\'' +
                ", systemOs='" + systemOs + '\'' +
                ", ahmet='" + ahmet + '\'' +
                ", pi=" + pi +
                ", xmlName='" + xmlName + '\'' +
                ", xmlDouble=" + xmlDouble +
                ", beanBField='" + beanBField + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                '}';
    }
}

@Component
class B {
    @Value("beanBField")
    private String beanBField;

    public String getBeanBField() {
        return beanBField;
    }
}

class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("valuespel.xml");
        ValueBean valueBean = (ValueBean) applicationContext.getBean("valueBean");

        System.out.println(valueBean.toString());

        System.out.println();
        valueBean.getSystemProperties().forEach((k,v) -> System.out.printf("%s : %s%n", k, v));
    }
}

