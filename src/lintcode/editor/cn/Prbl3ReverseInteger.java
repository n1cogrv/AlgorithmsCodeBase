package lintcode.editor.cn;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @Time 2021-04-06 2:17 PM
 * @Author MijazzChan
 */
public class Prbl3ReverseInteger {
    public static void main(String[] args) {
        Arrays.stream(new int[]{126, 978, 900, 0}).map(
                integer -> new Prbl3ReverseInteger().new Solution()
                        .reverseInteger(integer))
                .forEach(System.out::println);
    }

    class Solution{
        public int reverseInteger(int number) {
            int goal = 0;
            if (number > 999 || number < 100) {
                throw new NumberFormatException("Problem sample exceed given limit");
            }
            while (number != 0) {
                goal *= 10;
                goal += number % 10;
                number /= 10;
            }
            return goal;
        }

    }

}
