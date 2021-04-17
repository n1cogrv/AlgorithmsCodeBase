package xyz.mijazz.leetcode.utils;/**
 * @Time 2021-04-10 2:33 PM
 * @Author MijazzChan
 */

import java.util.concurrent.ThreadLocalRandom;

public class MyMath {

    public static final ThreadLocalRandom randStream = ThreadLocalRandom.current();

    public static int randomInt(int from, int to) {
        return randStream.nextInt(Math.min(from, to), Math.max(from, to));
    }

    public static double randomDouble(double from, double to) {
        return randStream.nextDouble(Math.min(from, to), Math.max(from, to));
    }

    public static int[] randomIntArray(int size, int from, int to) {
        return randStream.ints(size, from, to).toArray();
    }

    public static int[] randomIntArray(int size) {
        return randStream.ints(size, 0, 10_000).toArray();
    }

    public static double[] randomDoubleArray(int size, double from, double to) {
        return randStream.doubles(size, from, to).toArray();
    }

    public static double[] randomDoubleArray(int size) {
        return randStream.doubles(size, 0, 100).toArray();
    }


}
