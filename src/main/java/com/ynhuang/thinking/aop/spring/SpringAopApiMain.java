package com.ynhuang.thinking.aop.spring;

import com.ynhuang.thinking.aop.instances.DefaultEchaoImpl;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
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

        //proxyFactory.addAdvice(new MyBeforeAdvice());
        proxyFactory.addAdvice(new MyInterceptor());


        DefaultEchaoImpl echao = (DefaultEchaoImpl)proxyFactory.getProxy();

        System.out.println(echao.echo("123"));

    }

    static class MyBeforeAdvice implements MethodBeforeAdvice {

        @Override
        public void before(Method method, Object[] objects, Object o) throws Throwable {
            System.out.println("before log...");
        }
    }

    static class MyInterceptor implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {

            System.out.println("method before invoke...");

            //return null;
            return invocation.proceed();
        }
    }
}
