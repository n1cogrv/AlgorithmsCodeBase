//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Note: 
//Assume we are dealing with an environment that could only store integers withi
//n the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this prob
//lem, assume that your function returns 0 when the reversed integer overflows. 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics Math 
// 👍 3900 👎 6059

package leetcode.editor.en;

//java: Reverse Integer
public class Prbl7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Prbl7ReverseInteger().new Solution();
        solution.reverse(1534236469);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            StringBuilder builder = new StringBuilder(Integer.toString(Math.abs(x))).reverse();
            boolean isNegNum = x < 0;
            try {
                x = Integer.parseInt(builder.toString());
            } catch (NumberFormatException e) {
                return 0;
            }
            return isNegNum ? -x : x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}