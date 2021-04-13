package leetcode.editor.en;

import xyz.mijazz.leetcode.utils.ListNode;

import java.util.logging.Logger;

//2021-04-13 15:58:16
//java: Linked List Cycle II
//QuestionId: 142
//https://www.youtube.com/watch?v=pfA0VuvwpVg
public class Prbl142LinkedListCycleII {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl142LinkedListCycleII().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {

        public ListNode nodeInLoop(ListNode head) {
            // Place show ptr and fast ptr at head.
            // Slow ptr moves 1 step per iter, fast ptr moves 2 step per iter.
            // They will eventually bump into each other in the the loop if there is one.
            ListNode slowPtr = head;
            ListNode fastPtr = head;
            while (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
                // if they bump into each other, return either.
                // It's certain that this node is inside the loop.
                if (slowPtr == fastPtr) return slowPtr;
            }
            // They never meet.
            return null;
        }

        public ListNode detectCycle(ListNode head) {
            // NULL Check
            if (head == null || head.next == null) return null;
            ListNode intersectionNode = nodeInLoop(head);
            if (intersectionNode == null) return null;
            // Place node(curr) from the beginning of the node.
            // curr moves 1 step per iter, intersectionNode moves 1 step per iter.
            ListNode curr = head;
            // They will eventually meet each other at the beginning of the loop.
            while (curr != intersectionNode) {
                curr = curr.next;
                intersectionNode = intersectionNode.next;
            }
            return curr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given a linked list, return the node where the cycle begins. If there is no cy
//cle, return null. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to. N
//ote that pos is not passed as a parameter. 
//
// Notice that you should not modify the linked list. 
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 104]. 
// -105 <= Node.val <= 105 
// pos is -1 or a valid index in the linked-list. 
// 
//
// 
// Follow up: Can you solve it using O(1) (i.e. constant) memory? 
// Related Topics Linked List Two Pointers 
// 👍 3998 👎 300
