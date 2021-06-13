package leetcode.editor.en;

import xyz.mijazz.leetcode.utils.ListNode;
import xyz.mijazz.leetcode.utils.MyMath;

import java.util.logging.Logger;

//2021-06-13 14:55:04
//java: Add Two Numbers II
//QuestionId: 445
public class Prbl445AddTwoNumbersII {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl445AddTwoNumbersII().new Solution();
        ListNode ans = solution.addTwoNumbers(
                ListNode.buildListNodeFrom(MyMath.randomIntArray(5, 0, 10)),
                ListNode.buildListNodeFrom(MyMath.randomIntArray(8, 0, 10)));

        System.out.println(ans);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int[] i1 = getVal(l1);
            int[] i2 = getVal(l2);
            boolean carry = false;
            ListNode ans = new ListNode(Integer.MAX_VALUE);
            int i = i1.length - 1;
            int j = i2.length - 1;
            while (i >= 0 || j >= 0 || carry) {
                int a = i >= 0 ? i1[i] : 0;
                int b = j >= 0 ? i2[j] : 0;
                int tmp = a + b + (carry ? 1 : 0);
                carry = tmp > 9;
                tmp %= 10;
                if (ans.val == Integer.MAX_VALUE) {
                    ans.val = tmp % 10;
                } else {
                    ListNode pending = new ListNode(tmp);
                    pending.next = ans;
                    ans = pending;
                }
                i--;
                j--;
            }
            return ans;
        }

        public int[] getVal(ListNode l) {
            StringBuilder s = new StringBuilder();
            while (l != null) {
                s.append(l.val);
                l = l.next;
            }
            int len = s.length();
            int[] numHoldingArr = new int[len];
            for (int i = 0; i < len; i++) {
                numHoldingArr[i] = s.charAt(i) - '0';
            }
            return numHoldingArr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//You are given two non-empty linked lists representing two non-negative integer
//s. The most significant digit comes first and each of their nodes contains a sin
//gle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [7,2,4,3], l2 = [5,6,4]
//Output: [7,8,0,7]
// 
//
// Example 2: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [8,0,7]
// 
//
// Example 3: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
//
// 
// Follow up: Could you solve it without reversing the input lists? 
// Related Topics Linked List 
// 👍 2459 👎 202
