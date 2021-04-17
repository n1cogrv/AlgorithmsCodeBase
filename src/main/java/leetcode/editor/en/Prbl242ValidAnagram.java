//Given two strings s and t, return true if t is an anagram of s, and false othe
//rwise. 
//
// 
// Example 1: 
// Input: s = "anagram", t = "nagaram"
//Output: true
// Example 2: 
// Input: s = "rat", t = "car"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you adapt
// your solution to such a case? 
// Related Topics Hash Table Sort 
// 👍 2490 👎 162

package leetcode.editor.en;

//java: Valid Anagram
public class Prbl242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new Prbl242ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            int[] az = new int[26];
            for (char c : s.toCharArray()) {
                az[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                az[c - 'a']--;
                if (az[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}