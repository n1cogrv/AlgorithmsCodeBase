package xyz.mijazz.leetcode.bitwiseoperation;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Time 2021-04-17 4:00 PM
 * @Author MijazzChan
 */

@DisplayName(value = "Bitwise Operation Test Specified for Integer Operation")
@DisplayNameGeneration(value = DisplayNameGenerator.Simple.class)
class IntBitwiseOperationTest {

    static IntBitwiseOperation intBitwiseOperation;

    @BeforeAll
    static void initTest() {
        intBitwiseOperation = new IntBitwiseOperation();
    }

    @Test
    void isTwoIntegerHasDifferentSign() {
        int testSize = Integer.MAX_VALUE;
        IntStream.range(1, testSize).forEach(
                x -> Assertions.assertTrue(intBitwiseOperation.isTwoIntegerHasDifferentSign(x, -x))
        );
    }


    @Test
    @Disabled
    void isTwoIntegerHasDifferentSignUsingMultiply() {
        int testSize = 100_000_000;
        IntStream.range(1, testSize).forEach(
                x -> Assertions.assertTrue(intBitwiseOperation.isTwoIntegerHasDifferentSignUsingMultiply(x, -x))
        );
    }

    @Test
    void isTwoIntegerHasDifferentSignUsingCompare() {
        int testSize = Integer.MAX_VALUE;
        IntStream.range(1, testSize).forEach(
                x -> Assertions.assertTrue(intBitwiseOperation.isTwoIntegerHasDifferentSignUsingCompare(x, -x))
        );
    }

    @Test
    void isPowerOf2() {
        int testSize = 10_000;
        int[] powerOf2NumArray = IntStream.range(-testSize, testSize).filter(
                x -> intBitwiseOperation.isPowerOf2(x)
        ).toArray();
        System.out.printf("Power of 2 within range %d: \n%s", testSize, Arrays.toString(powerOf2NumArray));
    }

    @Test
    void isOdd() {
        Stream<Integer> checkList =
                Stream.of(
                        1, -1, 21, -21, Integer.MAX_VALUE,
                        2, -2, 22, -22, Integer.MIN_VALUE,
                        0
                );
        Stream<Boolean> resultList =
                Stream.of(
                        true, true, true, true, true,
                        false, false, false, false, false,
                        false
                );

        List<Boolean> expectResult = resultList.collect(Collectors.toList());
        List<Boolean> realResult = checkList.map(intBitwiseOperation::isOdd).collect(Collectors.toList());

        Assertions.assertEquals(expectResult, realResult);
    }
}
