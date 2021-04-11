package leetcode.editor.en;

import xyz.mijazz.leetcode.utils.MyMath;

import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.stream.Stream;

//2021-04-11 16:05:53
//java: Maximum Subarray
//QuestionId: 53
public class Prbl53MaximumSubarray{
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args){
        Solution solution = new Prbl53MaximumSubarray().new Solution();
        int[] testArray = MyMath.randomIntArray(10, -10, 10);
        logger.info(Arrays.toString(testArray));
        System.out.println(solution.maxSubArray(testArray));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i-1];
            }
        }

        return Arrays.stream(nums).max().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//Follow up: If you have figured out the O(n) solution, try coding another solut
//ion using the divide and conquer approach, which is more subtle. Related Topics 
//Array Divide and Conquer Dynamic Programming 
// 👍 11497 👎 555
