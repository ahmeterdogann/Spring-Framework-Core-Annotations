package com.ahmeterdogan.qualifier;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class A {
    private IX ix1;
    private IX ix2;

    public A(@Qualifier("b") IX ix1, @Qualifier("c") IX ix2) {
        this.ix1 = ix1;
        this.ix2 = ix2;
    }
    public void doSth() {
        ix1.doSth();
        ix2.doSth();
    }
}

@Component("c")
class C implements IX{
    @Override
    public void doSth() {
        System.out.println("c.doSth()");
    }
}

@Component
@Qualifier("b")
class B implements IX{
    @Override
    public void doSth() {
        System.out.println("b.doSth()");
    }
}

interface IX {
    void doSth();
}
