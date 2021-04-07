package lintcode.editor.cn;

import java.util.Arrays;

/**
 * @Time 2021-04-06 2:51 PM
 * @Author MijazzChan
 */
public class Prbl1Aplusb {
    public static void main(String[] args) {
        Arrays.stream(new int[]{-126, -978, 900, 0}).map(
        integer1 -> {
            int integer2 = (int) Math.floor(Math.random() * 1e6);
            System.out.printf("%6d + %6d = %d | ", integer1, integer2, integer1+integer2);
            return new Prbl1Aplusb().new Solution().aplusb(integer1, integer2);

        }).forEach(System.out::println);
    }

    class Solution{
        public int aplusb(int a, int b) {
//            int sum = a ^ b;
//            int carry = (a & b) << 1;
//            if (carry == 0) {
//                return sum;
//            }
//            return aplusb(sum, carry);
            if (b == 0) {
                return a;
            }
            return aplusb(a ^ b, (a & b) << 1);
        }

    }
}
