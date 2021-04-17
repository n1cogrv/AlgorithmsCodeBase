package leetcode.editor.en;

import java.util.Stack;
import java.util.logging.Logger;
import java.util.stream.Stream;

//2021-04-13 14:09:12
//java: Valid Parentheses
//QuestionId: 20
public class Prbl20ValidParentheses {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl20ValidParentheses().new Solution();
        Stream.of("(())", "([]", "({([])})", "([[[]]})").forEach(
                testCase -> {
                    boolean result = solution.isValid(testCase);
                    logger.info(testCase.concat(" -> ").concat(Boolean.toString(result)));
                }
        );

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            int length = s.length();
            // Length is always gt 1.
//        if (length == 0) return false;
            if ((length & 1) != 0) {
                // Odd length is always false
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == 40 || c == 91 || c == 123) {
                    stack.push(c);
                } else {
                    if (stack.empty()) return false;
                    if (stack.pop() / 10 != c / 10) return false;
                }
            }
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
// 40, 91, 123
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: s = "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: s = "{[]}"
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 
// 👍 7235 👎 298
