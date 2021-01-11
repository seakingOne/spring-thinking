package com.ynhuang.thinking.aop.instances;

/**
 * @author YuHuang
 */
public class DefaultEchaoImpl implements Echao {
    @Override
    public String echo(String message) {
        return "[echo] = " +  message;
    }
}
