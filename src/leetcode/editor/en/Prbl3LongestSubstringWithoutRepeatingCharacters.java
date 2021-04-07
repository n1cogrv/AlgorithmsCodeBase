//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 
// 👍 13663 👎 706

package leetcode.editor.en;

import java.util.HashMap;

//java: Longest Substring Without Repeating Characters
public class Prbl3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args){
        Solution solution = new Prbl3LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcfabc"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> seen = new HashMap<>();
        int maximum_length = 0;
        int start = 0;

        for(int end = 0; end < s.length(); end++)
        {
            // Checking if we have already seen the element or not
            if(seen.containsKey(s.charAt(end)))
            {
                // If we have seen the number, move the start pointer
                // to position after the last occurrence
                start = Math.max(start, seen.get(s.charAt(end)) + 1);
            }

            // Updating the last seen value of the character
            seen.put(s.charAt(end), end);
            maximum_length = Math.max(maximum_length, end-start + 1);
        }
        return maximum_length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}