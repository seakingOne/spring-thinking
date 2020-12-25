package com.ynhuang.thinking.event.spring.myevent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.context.support.AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME;

/**
 * @author YuHuang
 */
//@EnableAsync
public class MySpringEventDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(MySpringEventDemo.class);

        applicationContext.refresh();

        ApplicationEventMulticaster applicationEventMulticaster = applicationContext.getBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME,
                ApplicationEventMulticaster.class);

        if (applicationEventMulticaster instanceof SimpleApplicationEventMulticaster) {

            ExecutorService executorService = Executors.newSingleThreadExecutor();

            SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = (SimpleApplicationEventMulticaster) applicationEventMulticaster;
            simpleApplicationEventMulticaster.setTaskExecutor(executorService);

            applicationContext.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
                @Override
                public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {

                    if (!executorService.isShutdown()) {
                        executorService.shutdown();
                    }

                }
            });
        }


        applicationContext.publishEvent(new MySpringEventObject("hello world !"));
        applicationContext.close();

    }

    @EventListener
    //@Async
    public void onEvent(MySpringEventObject eventObject) {
        System.err.printf("[线程 ： %s] onEvent方法监听到事件 : %s\n", Thread.currentThread().getName(), eventObject);
    }
//
//    @Bean
//    public Executor taskExecutor() {
//        ExecutorService executorService = newSingleThreadExecutor(new CustomizableThreadFactory("my-spring-thread-executor"));
//        return executorService;
//    }

}
