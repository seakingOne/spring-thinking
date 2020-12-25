package com.ynhuang.thinking.beanDefinition.instance.serviceload.jdk;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author YuHuang
 */
public class JdkServiceLoaderDemo {

    public static void main(String[] args) {

        ServiceLoader<MyServiceLoaderInterface> load = ServiceLoader.load(MyServiceLoaderInterface.class, Thread.currentThread().getContextClassLoader());
        Iterator<MyServiceLoaderInterface> iterator = load.iterator();
        while (iterator.hasNext()) {
            MyServiceLoaderInterface next = iterator.next();

            System.out.println(next.sayHello());

        }

    }

}
