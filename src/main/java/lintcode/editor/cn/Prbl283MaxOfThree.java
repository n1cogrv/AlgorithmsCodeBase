package lintcode.editor.cn;/**
 * @Time 2021-04-06 4:04 PM
 * @Author MijazzChan
 */

import java.util.stream.Stream;

public class Prbl283MaxOfThree {
    public static void main(String[] args) {
        Stream.of(76895, 97).map(
                instance -> new Prbl283MaxOfThree().new Solution().maxOfThreeNumbers(instance, 99, 0)
        ).forEach(System.out::println);
    }

    class Solution {
        public int maxOfThreeNumbers(int num1, int num2, int num3) {
            return Stream.of(num1, num2, num3).max(Integer::compareTo).get();
        }
    }
}
