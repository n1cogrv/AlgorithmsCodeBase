package leetcode.editor.en;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//2021-08-24 17:54:33
//java: Complex Number Multiplication
//QuestionId: 537
public class Prbl537ComplexNumberMultiplication {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl537ComplexNumberMultiplication().new Solution();

        System.out.println(solution.complexNumberMultiply("1+1i", "1-1i"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String complexNumberMultiply(String num1, String num2) {
            int splitIdx1 = num1.indexOf('+');
            int splitIdx2 = num2.indexOf('+');

            int[] reals = {
                    Integer.parseInt(num1.substring(0, splitIdx1)),
                    Integer.parseInt(num2.substring(0, splitIdx2))
            };
            int[] imaginaries = {
                    Integer.parseInt(num1.substring(splitIdx1+1, num1.length() - 1)),
                    Integer.parseInt(num2.substring(splitIdx2+1, num2.length() - 1))
            };

            int real = reals[0] * reals[1] - imaginaries[0] * imaginaries[1];
            int img = reals[0] * imaginaries[1] + reals[1] * imaginaries[0];

            return new StringBuilder()
                    .append(real).append('+')
                    .append(img).append('i')
                    .toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}

//A complex number can be represented as a string on the form "real+imaginaryi" 
//where: 
//
// 
// real is the real part and is an integer in the range [-100, 100]. 
// imaginary is the imaginary part and is an integer in the range [-100, 100]. 
// i² == -1. 
// 
//
// Given two complex numbers num1 and num2 as strings, return a string of the 
//complex number that represents their multiplications. 
//
// 
// Example 1: 
//
// 
//Input: num1 = "1+1i", num2 = "1+1i"
//Output: "0+2i"
//Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it 
//to the form of 0+2i.
// 
//
// Example 2: 
//
// 
//Input: num1 = "1+-1i", num2 = "1+-1i"
//Output: "0+-2i"
//Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert 
//it to the form of 0+-2i.
// 
//
// 
// Constraints: 
//
// 
// num1 and num2 are valid complex numbers. 
// 
// Related Topics Math String Simulation 👍 363 👎 907
