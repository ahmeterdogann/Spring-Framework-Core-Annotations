package com.ahmeterdogan.primary;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class A {
    private IX ix1;
    private IX ix2;

    public A(IX ix1, @Qualifier("c") IX ix2) {
        this.ix1 = ix1;
        this.ix2 = ix2;
    }
    public void doSth() {
        ix1.doSth();
        ix2.doSth();
    }
}

@Component
class C implements IX{
    @Override
    public void doSth() {
        System.out.println("c.doSth()");
    }
}

@Component
class B implements IX{
    @Override
    public void doSth() {
        System.out.println("b.doSth()");
    }
}

@Component
@Primary
class D implements IX {

    @Override
    public void doSth() {
        System.out.println("d.doSth()");
    }
}

interface IX {
    void doSth();
}
