//Given the head of a singly linked list, reverse the list, and return the rever
//sed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. C
//ould you implement both? 
// Related Topics Linked List 
// 👍 6710 👎 129

package leetcode.editor.en;

import leetcode.editor.en.UtilsTools.ListNode;

import java.util.List;
import java.util.logging.Logger;

//java: Reverse Linked List
public class Prbl206ReverseLinkedList {
    private static final Logger logger = Logger.getLogger(Prbl206ReverseLinkedList.class.getName());
    public static void main(String[] args) {
        Solution solution = new Prbl206ReverseLinkedList().new Solution();
        ListNode listNode = UtilsTools.buildListNodeFrom(new int[]{1, 2, 3, 4, 5});
        logger.info(listNode.toString());
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
        public ListNode reverseList(ListNode head) {
            ListNode previous = null;
            ListNode current = head;
            while (null != current) {
                ListNode nextTemp = current.next;
                current.next = previous;
                previous = current;
                current = nextTemp;
            }
            return previous;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}