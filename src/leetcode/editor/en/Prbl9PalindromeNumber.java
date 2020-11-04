//Determine whether an integer is a palindrome. An integer is a palindrome when 
//it reads the same backward as forward. 
//
// Follow up: Could you solve it without converting the integer to a string? 
//
// 
// Example 1: 
//
// 
//Input: x = 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Example 4: 
//
// 
//Input: x = -101
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics Math 
// 👍 2711 👎 1634

package leetcode.editor.en;
//java: Palindrome Number
public class Prbl9PalindromeNumber{
    public static void main(String[] args){
        Solution solution = new Prbl9PalindromeNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            // Negative Numbers pass.
            return false;
        }
        if (x < 10) {
            // All single digit number is PalindromeNumber.
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int reverser = 0;
        // Can not reverse the whole number, cuz it will cause overflow when dealing with number near MAX_VALUE
        while (reverser < x) {
            reverser = reverser * 10 + x % 10;
            x = x / 10;
        }
        // Note when digit count is odd, the middle digit does not matter.(87378)-> 873, 87
        // So reverser/10 will remove the middle digit
        return (reverser == x || reverser / 10 == x);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}