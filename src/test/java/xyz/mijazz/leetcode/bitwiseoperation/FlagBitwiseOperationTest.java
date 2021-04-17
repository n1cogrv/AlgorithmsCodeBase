package xyz.mijazz.leetcode.bitwiseoperation;

import org.junit.jupiter.api.*;

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
    void initTest() {
        flagBitwiseOperation = new FlagBitwiseOperation();
    }

    @Test
    void setFlagAtLocationThenVerify() {
        int[] temp = ThreadLocalRandom.current().ints(8, 0, 2).toArray();

    }

}