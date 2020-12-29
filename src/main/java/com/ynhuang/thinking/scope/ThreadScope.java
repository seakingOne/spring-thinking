package com.ynhuang.thinking.scope;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

/**
 * @author YuHuang
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope("thread-scope")
public @interface ThreadScope {

}
