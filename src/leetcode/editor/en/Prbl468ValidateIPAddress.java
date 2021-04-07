//Given a string IP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP i
//s a valid IPv6 address or "Neither" if IP is not a correct IP of any type. 
//
// A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 
//and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0
//" are valid IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168
//@1.1" are invalid IPv4 addresses. 
//
// A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where: 
//
// 
// 1 <= xi.length <= 4 
// xi is a hexadecimal string which may contain digits, lower-case English lette
//r ('a' to 'f') and upper-case English letters ('A' to 'F'). 
// Leading zeros are allowed in xi. 
// 
//
// For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0
//:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334
//" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses. 
//
// 
// Example 1: 
//
// 
//Input: IP = "172.16.254.1"
//Output: "IPv4"
//Explanation: This is a valid IPv4 address, return "IPv4".
// 
//
// Example 2: 
//
// 
//Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
//Output: "IPv6"
//Explanation: This is a valid IPv6 address, return "IPv6".
// 
//
// Example 3: 
//
// 
//Input: IP = "256.256.256.256"
//Output: "Neither"
//Explanation: This is neither a IPv4 address nor a IPv6 address.
// 
//
// Example 4: 
//
// 
//Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
//Output: "Neither"
// 
//
// Example 5: 
//
// 
//Input: IP = "1e1.4.5.6"
//Output: "Neither"
// 
//
// 
// Constraints: 
//
// 
// IP consists only of English letters, digits and the characters '.' and ':'. 
// 
// Related Topics String 
// 👍 467 👎 1981

package leetcode.editor.en;

import java.util.regex.Pattern;
import java.util.stream.Stream;

//java: Validate IP Address
public class Prbl468ValidateIPAddress {
    public static void main(String[] args) {
        Solution solution = new Prbl468ValidateIPAddress().new Solution();
        Stream.of("172.16.254.1", "12..33.4",  "2001:0db8:85a3:0:0:8A2E:0370:7334", "256.256.256.256", "2001:0db8:85a3:0:0:8A2E:0370:7334:")
                .map(solution::validIPAddress)
                .forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Pattern pattern = Pattern.compile("^[0-9A-Fa-f]{1,4}$");
        public String validIPAddress(String IP) {
            String NAY = "Neither";
            String I4 = "IPv4";
            String I6 = "IPv6";
            String[] ips;
            boolean v4Flag = IP.indexOf('.') >= 0;
            boolean v6Flag = IP.indexOf(':') >= 0;
            if ((v4Flag&&v6Flag) ||(!v4Flag && !v6Flag) || IP.endsWith(".") || IP.endsWith(":")) {
                return NAY;
            }
            if (v4Flag) {
                ips = IP.split("\\.");
                if (ips.length != 4) return NAY;
                for (String seq : ips) {
                    if (!isValid4(seq)) {
                        return NAY;
                    }
                }
                return I4;
            } else {
                ips = IP.split(":");
                if (ips.length != 8) return NAY;
                for (String seq : ips) {
                    if (!isValid6(seq)) {
                        return NAY;
                    }
                }
                return I6;
            }
        }

        public boolean isValid4(String s) {
            if (s.isEmpty()) {
                return false;
            }
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            if (chars.length > 1 && chars[0] == '0' || chars.length > 3) return false;
            int num = Integer.parseInt(s);
            return num >= 0 && num <= 255;
        }

        public boolean isValid6(String s) {
            return pattern.matcher(s).find();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}