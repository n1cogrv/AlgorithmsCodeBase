//Given a string s, return the first non-repeating character in it and return it
//s index. If it does not exist, return -1. 
//
// 
// Example 1: 
// Input: s = "leetcode"
//Output: 0
// Example 2: 
// Input: s = "loveleetcode"
//Output: 2
// Example 3: 
// Input: s = "aabb"
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s consists of only lowercase English letters. 
// 
// Related Topics Hash Table String 
// 👍 2834 👎 140

package leetcode.editor.en;

import java.io.UnsupportedEncodingException;
import java.util.stream.Stream;

//java: First Unique Character in a String
public class Prbl387FirstUniqueCharacterInAString{
    public static void main(String[] args){
        Solution solution = new Prbl387FirstUniqueCharacterInAString().new Solution();
        System.out.println(solution.firstUniqChar("aallea"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s){
        int[] az = new int[26];
        char[] ss = s.toCharArray();
        for (char c : ss) {
            az[c - 'a']++;
        }
        for (int i = 0; i < ss.length; ++i) {
            if (az[ss[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}