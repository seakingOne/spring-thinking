package com.ynhuang.compile;

/**
 * @author YuHuang
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 15000; i++) {
            CompileTest compileTest = new CompileTest();

            Long start = System.nanoTime();
            int add = compileTest.add(10, 20);
            System.out.println(add);

            System.out.println("第" + i + "次" + (System.nanoTime() - start));
        }

    }
}
