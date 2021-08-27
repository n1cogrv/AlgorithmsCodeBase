package leetcode.editor.en;

import xyz.mijazz.leetcode.utils.MyMath;

import java.util.logging.Logger;

//2021-08-27 18:11:59
//java: Single Number
//QuestionId: 136
public class Prbl136SingleNumber{
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args){
        Solution solution = new Prbl136SingleNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//Given a non-empty array of integers nums, every element appears twice except 
//for one. Find that single one. 
//
// You must implement a solution with a linear runtime complexity and use only 
//constant extra space. 
//
// 
// Example 1: 
// Input: nums = [2,2,1]
//Output: 1
// Example 2: 
// Input: nums = [4,1,2,1,2]
//Output: 4
// Example 3: 
// Input: nums = [1]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// Each element in the array appears twice except for one element which appears 
//only once. 
// 
// Related Topics Array Bit Manipulation 👍 7035 👎 232
