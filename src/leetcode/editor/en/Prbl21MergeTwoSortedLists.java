package leetcode.editor.en;

import xyz.mijazz.leetcode.utils.ListNode;

import java.util.logging.Logger;

//2021-04-11 15:10:04
//java: Merge Two Sorted Lists
//QuestionId: 21
public class Prbl21MergeTwoSortedLists {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl21MergeTwoSortedLists().new Solution();
        ListNode listNode = solution.mergeTwoLists(ListNode.buildListNodeFrom(new int[]{1, 9, 10}), ListNode.buildListNodeFrom(new int[]{1, 8, 10, 98}));
        logger.info(listNode.toString());
        /*
        Apr 11, 2021 3:39:11 PM leetcode.editor.en.Prbl21MergeTwoSortedLists main
        INFO: 1=>1=>8=>9=>10=>10=>98=>NULL
         */
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode resultListNode = new ListNode(Integer.MAX_VALUE);
            ListNode curr = resultListNode;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            curr.next = (l1 == null) ? l2 : l1;
            return resultListNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Merge two sorted linked lists and return it as a sorted list. The list should 
//be made by splicing together the nodes of the first two lists. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [1,2,4], l2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: l1 = [], l2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: l1 = [], l2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both l1 and l2 are sorted in non-decreasing order. 
// 
// Related Topics Linked List Recursion 
// 👍 6492 👎 756
