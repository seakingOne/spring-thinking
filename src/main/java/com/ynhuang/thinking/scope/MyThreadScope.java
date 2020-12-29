package com.ynhuang.thinking.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YuHuang
 */
public class MyThreadScope implements Scope {

    public static final String SCOPE_NAME = "thread-scope";

    private NamedThreadLocal<Map<String, Object>> cache = new NamedThreadLocal("my-thread-local") {

        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>(256);
        }
    };

    Map<String, Object> objectMap = cache.get();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        long id = Thread.currentThread().getId();
        if (objectMap.get(String.valueOf(id)) == null) {
            Object object = objectFactory.getObject();
            objectMap.put(String.valueOf(id), object);

            return object;
        } else {
            return objectMap.get(String.valueOf(id));
        }
    }

    @Override
    public Object remove(String name) {
        return objectMap.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return objectMap.remove(key);
    }

    @Override
    public String getConversationId() {
        return String.valueOf(Thread.currentThread().getId());
    }
}
