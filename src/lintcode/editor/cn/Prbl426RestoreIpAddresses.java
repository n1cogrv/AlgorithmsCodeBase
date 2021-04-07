package lintcode.editor.cn;/**
 * @Time 2021-04-06 4:26 PM
 * @Author MijazzChan
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Prbl426RestoreIpAddresses {
    public static void main(String[] args) {
        Stream.of("00003").map(
                instance -> new Prbl426RestoreIpAddresses().new Solution().restoreIpAddresses(instance)
        ).forEach(System.out::println);
    }

    class Solution {
        public List<String> restoreIpAddresses(String s) {
            int length = s.length();
            String temp1;
            String temp2;
            String temp3;
            String temp4;
            List result = new LinkedList<String>();

            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    for (int k = 1; k <= 3; k++) {
                        for (int l = 1; l <= 3; l++) {
                            if (i + j + k + l == length) {
                                temp1 = s.substring(0, i);
                                temp2 = s.substring(i, i + j);
                                temp3 = s.substring(i + j, i + j + k);
                                temp4 = s.substring(i + j + k);
                                if (isValid(temp1)
                                        && isValid(temp2)
                                        && isValid(temp3)
                                        && isValid(temp4)
                                ) {
                                    result.add(new StringBuilder(temp1).append('.').append(temp2).append('.').append(temp3).append('.').append(temp4).toString());
                                }
                            }
                        }
                    }
                }
            }

            return result;
        }

        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            if(chars.length > 1 && chars[0] == '0')return false;
            int num = Integer.parseInt(s);
            return num>=0 && num<=255;
        }

    }
}
