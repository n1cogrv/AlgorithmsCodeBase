package lintcode.editor.cn;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * @Time 2021-04-06 3:18 PM
 * @Author MijazzChan
 */
public class Prbl1300BashWin {
    public static void main(String[] args) {
        Arrays.stream(new int[]{1, 2, 4, 7, 8, 13}).mapToObj
//                (integer -> new Prbl1300BashWin().new Solution().canWinBash1(integer))
        (integer -> new Prbl1300BashWin().new Solution().canWinBash2(integer))
                .forEach(System.out::println);
    }

    class Solution {
        public boolean canWinBash1(int n) {
            Instant inst = Instant.now();
            boolean res = n % 4 != 0;
            System.out.println(Duration.between(inst, Instant.now()).toNanos());
            return res;
        }

        public boolean canWinBash2(int n) {
            Instant inst = Instant.now();
            boolean res = (n & 3) != 0;
            System.out.println(Duration.between(inst, Instant.now()).toNanos());
            return res;
        }

    }
}
