//Find the kth largest element in an unsorted array. Note that it is the kth lar
//gest element in the sorted order, not the kth distinct element. 
//
// Example 1: 
//
// 
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length. 
// Related Topics Divide and Conquer Heap 
// 👍 4494 👎 295

package leetcode.editor.en;

import java.util.Comparator;
import java.util.PriorityQueue;

//java: Kth Largest Element in an Array
public class Prbl215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new Prbl215KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<Integer>(Comparator.comparingInt(n -> n));
            for (int i : nums) {
                q.offer(i);
                if (q.size() > k) {
                    q.poll();
                }
            }
            return q.peek();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}