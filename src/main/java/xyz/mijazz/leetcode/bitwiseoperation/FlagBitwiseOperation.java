package xyz.mijazz.leetcode.bitwiseoperation;

/**
 * @Time 2021-04-17 6:10 PM
 * @Author MijazzChan
 */

/**
 * This class aims to demonstrate the possibility of using 1 byte variable
 * to store 8 boolean variables at the same time.
 * For 8 boolean variables, an extra memory space (8*1bit < size < 8*1Byte)
 * will be allocated. Based on [https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html]
 * boolean type's size is not precisely defined. It may be VM-dependent.
 * However, with the technique discussed below, it is theoretically possible
 * that you can use exact 8bit(1Byte) to store 8 bool.
 **/
public class FlagBitwiseOperation {


    private byte flags;

    public void toggleTrueAt(byte loc) {
        flags |= 1 << loc;
    }

    public void toggleFalseAt(byte loc) {
        flags &= ~(1 << loc);
    }

    public boolean isTrueAt(byte loc) {
        return (flags & (1 << loc)) == (1 << loc);
    }

}
