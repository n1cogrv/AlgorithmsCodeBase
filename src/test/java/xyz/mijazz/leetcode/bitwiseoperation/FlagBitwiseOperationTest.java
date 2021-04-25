package xyz.mijazz.leetcode.bitwiseoperation;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Time 2021-04-17 6:42 PM
 * @Author MijazzChan
 */

@DisplayName("Store 8 boolean flags into 1 byte")
@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
class FlagBitwiseOperationTest {

    static FlagBitwiseOperation flagBitwiseOperation;

    @BeforeAll
    static void initTest() {
        flagBitwiseOperation = new FlagBitwiseOperation();
    }

    @Test
    void setFlagAtLocationThenVerify() {
        // Generate array containing only 0 and 1.
        int[] temp = ThreadLocalRandom.current().ints(8, 0, 2).toArray();
        // Cast them to Boolean
        Object[] sourceBoolArray = Arrays.stream(temp).mapToObj(boolValue -> (boolValue == 1)).toArray();
        System.out.printf("Boolean array to be processed: (expected)\n%s\n", Arrays.toString(sourceBoolArray));
        // Place them into 1 single byte variable
        for (byte i = 0; i < sourceBoolArray.length; i++) {
            boolean currLocation = (boolean) sourceBoolArray[i];
            if (currLocation) {
                flagBitwiseOperation.toggleTrueAt(i);
            }
        }
        System.out.println("Booleans extracted from 1 single byte variable: (real)");
        // Print them out for verification
        for (byte i = 0; i < sourceBoolArray.length; i++) {
            System.out.printf("%s ", flagBitwiseOperation.isTrueAt(i));
        }

    }

    class LotsOfBytes {
        byte a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
        byte b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
        byte c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
        byte d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
        byte e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
    }

    class LotsOfInts {
        int a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
        int b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
        int c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
        int d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
        int e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
    }

    class LotsOfBooleans {
        boolean a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
        boolean b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
        boolean c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
        boolean d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
        boolean e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
    }


    private static final int SIZE = 1000000;

    @Test
    void test() {
        LotsOfBytes[] first = new LotsOfBytes[SIZE];
        LotsOfInts[] second = new LotsOfInts[SIZE];
        LotsOfBooleans[] third = new LotsOfBooleans[SIZE];

        System.gc();
        long startMem = getMemory();

        for (int i = 0; i < SIZE; i++) {
            first[i] = new LotsOfBytes();
        }

        System.gc();
        long endMem = getMemory();

        System.out.println("Size for LotsOfBytes: " + (endMem - startMem));
        System.out.println("Average size: " + ((endMem - startMem) / ((double) SIZE)));
        System.out.println("Appro. size for each Byte: " + ((endMem - startMem) / ((double) SIZE)) / 80);
        System.out.println();

        System.gc();
        startMem = getMemory();
        for (int i = 0; i < SIZE; i++) {
            second[i] = new LotsOfInts();
        }
        System.gc();
        endMem = getMemory();

        System.out.println("Size for LotsOfInts: " + (endMem - startMem));
        System.out.println("Average size: " + ((endMem - startMem) / ((double) SIZE)));
        System.out.println("Appro. size for each Int: " + ((endMem - startMem) / ((double) SIZE)) / 80);
        System.out.println();


        System.gc();
        startMem = getMemory();

        for (int i = 0; i < SIZE; i++) {
            third[i] = new LotsOfBooleans();
        }

        System.gc();
        endMem = getMemory();

        System.out.println("Size for LotsOfBooleans: " + (endMem - startMem));
        System.out.println("Average size: " + ((endMem - startMem) / ((double) SIZE)));
        System.out.println("Appro. size for each Boolean: " + ((endMem - startMem) / ((double) SIZE)) / 80);
        System.out.println();


        // Make sure nothing gets collected
        long total = 0;
        for (int i = 0; i < SIZE; i++) {
            total += first[i].a0 + second[i].a0 + ((!third[i].a0) ? 0 : 1);
        }
        System.out.println(total);
    }

    private static long getMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

}