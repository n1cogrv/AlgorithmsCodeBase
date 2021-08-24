package leetcode.editor.en;

import java.util.logging.Logger;

//2021-08-20 18:27:56
//java: Integer to Roman
//QuestionId: 12
public class Prbl12IntegerToRoman {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl12IntegerToRoman().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private StringBuilder sb = new StringBuilder();

        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        // Bit of violence will do the trick...
        // even though 77% fast
        public String intToRoman(int num) {
            return new StringBuilder(M[num / 1000])
                    .append(C[(num % 1000) / 100])
                    .append(X[(num % 100) / 10])
                    .append(I[(num % 10)])
                    .toString();
        }



        // Yet 100% fast...... dumb but fast...

//        public String _intToRoman(int num) {
//            helper(num);
//            return sb.toString();
//        }
//
//        public int helper(int num) {
//            if (num >= 1000) {
//                sb.append('M');
//                return helper(num - 1000);
//            } else if (num >= 900) {
//                sb.append("CM");
//                return helper(num - 900);
//            } else if (num >= 500) {
//                sb.append('D');
//                return helper(num - 500);
//            } else if (num >= 400) {
//                sb.append("CD");
//                return helper(num - 400);
//            } else if (num >= 100) {
//                sb.append("C");
//                return helper(num - 100);
//            } else if (num >= 90) {
//                sb.append("XC");
//                return helper(num - 90);
//            } else if (num >= 50) {
//                sb.append("L");
//                return helper(num - 50);
//            } else if (num >= 40) {
//                sb.append("XL");
//                return helper(num - 40);
//            } else if (num >= 10) {
//                sb.append("X");
//                return helper(num - 10);
//            } else if (num >= 9) {
//                sb.append("IX");
//                return helper(num - 9);
//            } else if (num >= 5) {
//                sb.append("V");
//                return helper(num - 5);
//            } else if (num >= 4) {
//                sb.append("IV");
//                return helper(num - 4);
//            } else if (num >= 1) {
//                sb.append("I");
//                return helper(num - 1);
//            } else if (num == 0) {
//                return 0;
//            }
//            return 0;
//        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D 
//and M. 
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
// For example, 2 is written as II in Roman numeral, just two one's added 
//together. 12 is written as XII, which is simply X + II. The number 27 is written as 
//XXVII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. 
//However, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same 
//principle applies to the number nine, which is written as IX. There are six 
//instances where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given an integer, convert it to a roman numeral. 
//
// 
// Example 1: 
//
// 
//Input: num = 3
//Output: "III"
// 
//
// Example 2: 
//
// 
//Input: num = 4
//Output: "IV"
// 
//
// Example 3: 
//
// 
//Input: num = 9
//Output: "IX"
// 
//
// Example 4: 
//
// 
//Input: num = 58
//Output: "LVIII"
//Explanation: L = 50, V = 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: num = 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num <= 3999 
// 
// Related Topics Hash Table Math String 👍 2144 👎 3433
