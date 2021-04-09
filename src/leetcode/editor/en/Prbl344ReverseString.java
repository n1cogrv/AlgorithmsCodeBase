//Write a function that reverses a string. The input string is given as an array
// of characters s. 
//
// 
// Example 1: 
// Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// Example 2: 
// Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s[i] is a printable ascii character. 
// 
//
// 
// Follow up: Do not allocate extra space for another array. You must do this by
// modifying the input array in-place with O(1) extra memory. 
// Related Topics Two Pointers String 
// 👍 2253 👎 762

package leetcode.editor.en;

//java: Reverse String
public class Prbl344ReverseString {
    public static void main(String[] args) {
        Solution solution = new Prbl344ReverseString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int frontPtr = 0;
            int backPtr = s.length - 1;
            while (frontPtr < backPtr) {
                s[frontPtr] = (char) (s[frontPtr] ^ s[backPtr]);
                s[backPtr] = (char) (s[frontPtr] ^ s[backPtr]);
                s[frontPtr] = (char) (s[frontPtr] ^ s[backPtr]);
                frontPtr++;
                backPtr--;
            }
            return;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}