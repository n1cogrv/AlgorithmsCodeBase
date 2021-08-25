package leetcode.editor.en;

import java.util.logging.Logger;

//2021-08-25 19:09:02
//java: Sum of Square Numbers
//QuestionId: 633
public class Prbl633SumOfSquareNumbers {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl633SumOfSquareNumbers().new Solution();
        System.out.println(solution.judgeSquareSum(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean judgeSquareSum(int c) {
            if (c < 3) return true;

            int a = 0;
            int b = (int) Math.sqrt(c);

//            long r = c;
//            while (r * r - c > 0) {
//                r = (r + c / r) / 2;
//            }
//            int b = (int) r & (0x7fffffff);

            int temp;

            while (a <= b) {
                temp = a * a + b * b;
                if (temp < c) a++;
                else if (temp > c) b--;
                else return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given a non-negative integer c, decide whether there're two integers a and b 
//such that a² + b² = c. 
//
// 
// Example 1: 
//
// 
//Input: c = 5
//Output: true
//Explanation: 1 * 1 + 2 * 2 = 5
// 
//
// Example 2: 
//
// 
//Input: c = 3
//Output: false
// 
//
// Example 3: 
//
// 
//Input: c = 4
//Output: true
// 
//
// Example 4: 
//
// 
//Input: c = 2
//Output: true
// 
//
// Example 5: 
//
// 
//Input: c = 1
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 0 <= c <= 2³¹ - 1 
// 
// Related Topics Math Two Pointers Binary Search 👍 861 👎 407
