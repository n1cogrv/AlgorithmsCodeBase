package leetcode.editor.en;

import java.util.logging.Logger;

//2021-07-03 17:49:32
//java: Longest Palindromic Substring
//QuestionId: 5
public class Prbl5LongestPalindromicSubstring {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl5LongestPalindromicSubstring().new Solution();
        logger.info(solution.longestPalindrome("babde"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int lo, maxLen, len;
        private char[] chars;

        public String longestPalindrome(String s) {
            len = s.length();
            chars = s.toCharArray();
            if (len < 2)
                return s;

            for (int i = 0; i < len - 1; i++) {
                extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
                extendPalindrome(s, i, i + 1); //assume even length.
            }
            return String.copyValueOf(chars, lo, maxLen);
        }

        private void extendPalindrome(String s, int j, int k) {
            while (j >= 0 && k < len && chars[j] == chars[k]) {
                j--;
                k++;
            }
            if (maxLen < k - j - 1) {
                lo = j + 1;
                maxLen = k - j - 1;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//
// 
// Related Topics String Dynamic Programming 
// 👍 11691 👎 729

