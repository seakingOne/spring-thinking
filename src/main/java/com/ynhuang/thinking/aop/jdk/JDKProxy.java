package com.ynhuang.thinking.aop.jdk;

import com.ynhuang.thinking.aop.instances.DefaultEchaoImpl;
import com.ynhuang.thinking.aop.instances.Echao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author YuHuang
 */
public class JDKProxy {

    public static void main(String[] args) {

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        Echao echao = (Echao)Proxy.newProxyInstance(contextClassLoader, new Class[]{Echao.class}, new MyInvocationHandler(new DefaultEchaoImpl()));
        System.out.println(echao.echo("hello"));

    }

    static class MyInvocationHandler implements InvocationHandler {

        private Object object;

        public MyInvocationHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (method.getDeclaringClass().isAssignableFrom(Echao.class)) {
                System.out.println("this is echao class.");
                return method.invoke(object, args);
            }

            return null;
        }
    }

}
