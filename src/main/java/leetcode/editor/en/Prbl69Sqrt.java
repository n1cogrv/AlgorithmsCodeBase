//Given a non-negative integer x, compute and return the square root of x. 
//
// Since the return type is an integer, the decimal digits are truncated, and on
//ly the integer part of the result is returned. 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since the decimal part is
// truncated, 2 is returned. 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics Math Binary Search 
// 👍 1696 👎 2167

package leetcode.editor.en;

//java: Sqrt(x)
public class Prbl69Sqrt {
    public static void main(String[] args) {
        Solution solution = new Prbl69Sqrt().new Solution();
        int solve = solution.mySqrt(20);
        System.out.println(solve);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            // Newton's Method
            // 牛顿下山法
            // f(rn) = rn^2 - x
            // when f(rn) ==> 0, r ==> sqrt(x)
            // f'(rn) = 2*rn
            // rn+1 = rn - (rn^2 -x) / (2*rn)
            // rn+1 = (rn+x/rn) / 2
            long r = x;
            while (r * r - x > 0) {
                r = (r + x / r) / 2;
            }
            return (int) r & (0x7fffffff);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}