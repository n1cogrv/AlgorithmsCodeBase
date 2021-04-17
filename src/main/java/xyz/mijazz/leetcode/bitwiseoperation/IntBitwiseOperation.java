package xyz.mijazz.leetcode.bitwiseoperation;


public class IntBitwiseOperation {

    /**
     * @param x integer
     * @param y integer
     * @return if two integer hold different sign.
     * Note that 0 is considered as negative number here.
     * To be clear:
     * (0,  2) => false
     * (0, -2) => true
     */
    public boolean isTwoIntegerHasDifferentSign(int x, int y) {
        return ((x ^ y) < 0);
    }

    // Demonstration Usage
    // Overflow expected
    public boolean isTwoIntegerHasDifferentSignUsingMultiply(int x, int y) {
        return x * y <= 0;
    }

    // Demonstration Usage
    public boolean isTwoIntegerHasDifferentSignUsingCompare(int x, int y) {
        return (x > 0 && y <= 0) || (x < 0 && y >= 0);
    }


    /**
     * @param x int
     * @return whether x is the power of 2
     * Note that negative number will not be considered as valid input, which is
     * if (x < 0) it always returns false.
     */
    public boolean isPowerOf2(int x) {
        return x != 0 && ((x & (x - 1)) == 0);
    }


    /**
     * @param x int
     * @return whether x is odd or even
     * 0  => false
     * if (x < 0) it will return just as isOdd(Math.abs(x)) will return.
     */
    public boolean isOdd(int x) {
        return (x & 1) == 1;
    }
}
