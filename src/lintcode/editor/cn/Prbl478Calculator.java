package lintcode.editor.cn;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Time 2021-04-06 3:44 PM
 * @Author MijazzChan
 */
public class Prbl478Calculator {
    public static void main(String[] args) {
        int rand = (int) Math.floor(Math.random() * 1e5);
        Stream.of(2, 4, 898, 212903).map(
                integer -> new Prbl478Calculator().new Solution().calculate(integer, '+' , rand)
        ).forEach(System.out::println);
    }

    class Solution{
        public int calculate(int a, char operator, int b) {
            switch (operator) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    return a / b;
            }

            return 0;
        }

    }
}
