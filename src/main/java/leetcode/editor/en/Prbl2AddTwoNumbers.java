package leetcode.editor.en;

import xyz.mijazz.leetcode.utils.ListNode;

import java.util.logging.Logger;

//2021-06-11 22:39:54
//java: Add Two Numbers
//QuestionId: 2
public class Prbl2AddTwoNumbers{
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args){
        Solution solution = new Prbl2AddTwoNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, false);
    }

    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, boolean isCarry) {
        if (l1 == null && l2 == null) {
            if (isCarry) {
                return new ListNode(1);
            }else {
                return null;
            }
        }

        int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + (isCarry ? 1 : 0);
        ListNode head = new ListNode(sum % 10);
        head.next = addTwoNumbersHelper(
                (l1 == null ? null : l1.next),
                (l2 == null ? null : l2.next),
                sum/10 == 1);
        return head;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}

//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
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
// Related Topics Linked List Math Recursion 
// 👍 12160 👎 2838

