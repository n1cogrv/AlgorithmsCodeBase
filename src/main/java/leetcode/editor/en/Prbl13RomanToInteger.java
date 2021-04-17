//Roman numerals are represented by seven different symbols: I, V, X, L, C, D an
//d M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, 2 is written as II in Roman numeral, just two one's added togeth
//er. 12 is written as XII, which is simply X + II. The number 27 is written as XX
//VII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. Ho
//wever, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same prin
//ciple applies to the number nine, which is written as IX. There are six instance
//s where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given a roman numeral, convert it to an integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "III"
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: s = "IV"
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: s = "IX"
//Output: 9
// 
//
// Example 4: 
//
// 
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
// 
//
// Example 5: `
//
// 
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 15 
// s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M'). 
// It is guaranteed that s is a valid roman numeral in the range [1, 3999]. 
// 
// Related Topics Math String 
// 👍 2738 👎 3811

package leetcode.editor.en;

import java.util.HashMap;

//java: Roman to Integer
public class Prbl13RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new Prbl13RomanToInteger().new Solution();
        int res = solution.romanToInt("MCMXCIV");
        System.out.println(res);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int romanToInt1(String s) {
            if (s.trim().length() == 0) {
                return 0;
            }
            int result = 0;
            HashMap<Character, Integer> respondTo = new HashMap(8);
            respondTo.put('I', 1);
            respondTo.put('V', 5);
            respondTo.put('X', 10);
            respondTo.put('L', 50);
            respondTo.put('C', 100);
            respondTo.put('D', 500);
            respondTo.put('M', 1000);
            int lastVal = 1000;
            for (int index = 0; index < s.length(); index++) {
                int val = respondTo.get(s.charAt(index));
                if (val > lastVal) result = result - lastVal * 2;
                result += val;
                lastVal = val;
            }
            return result;
        }

        public int romanToInt2(String s) {
            int result = 0;
            int[] respondTo = new int[26];
            respondTo['I' - 'A'] = 1;
            respondTo['V' - 'A'] = 5;
            respondTo['X' - 'A'] = 10;
            respondTo['L' - 'A'] = 50;
            respondTo['C' - 'A'] = 100;
            respondTo['D' - 'A'] = 500;
            respondTo['M' - 'A'] = 1000;
            int lastVal = 1000;
            for (int index = 0; index < s.length(); index++) {
                int val = respondTo[s.charAt(index) - 'A'];
                if (val > lastVal) result = result - lastVal * 2;
                result += val;
                lastVal = val;
            }
            return result;
        }

        public int romanToInt(String s) {
            return romanToInt2(s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}