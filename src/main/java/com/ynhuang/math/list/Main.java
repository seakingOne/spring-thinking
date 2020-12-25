package com.ynhuang.math.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuHuang
 */
public class Main {

    public static void main(String[] args) {

        List<List<String>> lists = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list.add("1");

        //lists.add(list);
        lists.add(new ArrayList<>(list));


        System.out.println(lists);

    }
}
