package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

//2021-08-26 00:13:45
//java: Letter Combinations of a Phone Number
//QuestionId: 17
public class Prbl17LetterCombinationsOfAPhoneNumber {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl17LetterCombinationsOfAPhoneNumber().new Solution();
    }

    // TODO: 28time, 48mem, optimization needed.
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String[] chars = {"",
                "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"
        };

        public List<String> letterCombinations(String digits) {
            int length = digits.length();

            if (length == 0) return Collections.emptyList();

            List<String> ans = new ArrayList<>(32);
            ans.add("");
            for (int i = 0; i < length; i++) {
                ans = helper(chars[digits.charAt(i) - '0'], ans);
            }
            return ans;
        }

        private List<String> helper(String combiner, List<? extends String> combinee) {
            List<String> _ans = new ArrayList<>();

            for (int i = 0; i < combiner.length(); i++) {
                for (String s : combinee) {
                    _ans.add(s + combiner.charAt(i));
                }
            }

            return _ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics Hash Table String Backtracking 👍 7143 👎 565
