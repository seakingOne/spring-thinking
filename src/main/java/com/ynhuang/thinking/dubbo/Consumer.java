package com.ynhuang.thinking.dubbo;

import com.ynhuang.thinking.dubbo.interfaces.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author YuHuang
 */
public class Consumer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/dubbo/dubbo-consumer.xml");
        context.start();
        DemoService demoService = context.getBean("demoService", DemoService.class);
        CompletableFuture<String> hello = demoService.sayHelloAsync("world");
        System.out.println("result1: " + hello.get());
    }
}
