package com.ynhuang.thinking.aop.spring;

import com.ynhuang.thinking.aop.instances.DefaultEchaoImpl;
import com.ynhuang.thinking.aop.instances.Echao;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author YuHuang
 */
public class SpringAopApiMain {

    public static void main(String[] args) {

        ProxyFactory proxyFactory = new ProxyFactory();
        //proxyFactory.setInterfaces(new Class[] {DefaultEchaoImpl.class});
        proxyFactory.setTarget(new DefaultEchaoImpl());

        proxyFactory.addAdvice(new MyBeforeAdvice());


        DefaultEchaoImpl echao = (DefaultEchaoImpl)proxyFactory.getProxy();

        System.out.println(echao.echo("123"));

    }

    static class MyBeforeAdvice implements MethodBeforeAdvice {

        @Override
        public void before(Method method, Object[] objects, Object o) throws Throwable {
            System.out.println("before log...");
        }
    }
}
