package com.ynhuang.thinking.conversion.customer;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Setter
@Getter
public class User {

    private int id;

    private String name;

    private Properties context;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", context=" + context +
                '}';
    }
}
