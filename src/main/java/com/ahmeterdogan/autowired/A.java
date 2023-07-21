package com.ahmeterdogan.autowired;

public class A {
    private B b;

    public A() {

    }
    public A(B b) {
        System.out.println("A(B b)");
        this.b = b;
    }

    public void doB() {
        System.out.println("A.doB()");
        b.doSth();
    }
}
