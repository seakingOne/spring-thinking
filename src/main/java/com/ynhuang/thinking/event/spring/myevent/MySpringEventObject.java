package com.ynhuang.thinking.event.spring.myevent;

import org.springframework.context.ApplicationEvent;

/**
 * @author YuHuang
 */
public class MySpringEventObject extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MySpringEventObject(String source) {
        super(source);
    }
}
