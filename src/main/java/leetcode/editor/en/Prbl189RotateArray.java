package leetcode.editor.en;

import java.util.logging.Logger;

//2021-08-27 17:18:59
//java: Rotate Array
//QuestionId: 189
public class Prbl189RotateArray {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl189RotateArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {

            if (nums == null || nums.length < 2) {
                return;
            }

            k = k % nums.length;
            // [1,2,3,4,5,6,7] => [4,3,2,1,5,6,7]
            reverseHelper(nums, 0, nums.length - k - 1);
            // [4,3,2,1,5,6,7] => [4,3,2,1,7,6,5]
            reverseHelper(nums, nums.length - k, nums.length - 1);
            // [4,3,2,1,7,6,5] => [5,6,7,1,2,3,4]
            reverseHelper(nums, 0, nums.length - 1);

        }

        private void reverseHelper(int[] nums, int i, int j) {
            while (i < j) {
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
                nums[i++] ^= nums[j--];

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given an array, rotate the array to the right by k steps, where k is non-
//negative. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁵ 
// 
//
// 
// Follow up: 
//
// 
// Try to come up with as many solutions as you can. There are at least three 
//different ways to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
// Related Topics Array Math Two Pointers 👍 5446 👎 980
