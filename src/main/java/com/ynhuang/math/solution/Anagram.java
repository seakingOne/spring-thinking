package com.ynhuang.math.solution;

import java.util.Arrays;

/**
 * @author YuHuang
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 */
public class Anagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram1";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(chars1);

        boolean equals = Arrays.equals(chars, chars1);

        return equals;
    }
}
