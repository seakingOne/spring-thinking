package com.ynhuang.thinking.aop.cglib;

import com.ynhuang.thinking.aop.instances.DefaultEchaoImpl;
import com.ynhuang.thinking.aop.instances.Echao;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author YuHuang
 */
public class CglibProxy {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DefaultEchaoImpl.class);
        enhancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before test...");
                return methodProxy.invokeSuper(o, objects);
            }
        });

        Echao echao = (Echao)enhancer.create();
        System.out.println(echao.echo("test..."));

    }

}
