package com.ynhuang.compile;

/**
 * @author YuHuang
 */
public class CompileTest {

    private volatile int c = 0;

    public int add(int a, int b) throws InterruptedException {

        //Thread.sleep(500);

        c = a + b;
        return c;
    }
}
