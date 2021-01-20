package com.ynhuang.reference;

import com.ynhuang.thinking.conversion.customer.User;

/**
 * @author YuHuang
 */
public class ReferenceMain {

    public static void main(String[] args) {

        User user = new User();
        user.setName("test");

        User user1 = user;
        System.out.println(user1 == user);

    }

}
