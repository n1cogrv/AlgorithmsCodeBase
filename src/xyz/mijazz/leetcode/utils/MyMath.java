package xyz.mijazz.leetcode.utils;/**
 * @Time 2021-04-10 2:33 PM
 * @Author MijazzChan
 */

import java.util.stream.Stream;

public class MyMath {

    public static int randomInt(int from, int to) {
        double seed = Math.random();
        int range = Math.abs(to - from);
        return (int) Math.round(seed * range + Math.min(from, to));
    }
}
