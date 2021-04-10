package leetcode.editor.en;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

//2021-04-10 17:11:58
//java: 3Sum
//QuestionId: 15
public class Prbl15ThreeSum{
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args){
        Solution solution = new Prbl15ThreeSum().new Solution();
        solution.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> results = new LinkedList<>();
        if (length < 3) return Collections.emptyList();
        if (length == 3 && Arrays.stream(nums).sum() == 0) {
            results.add(Arrays.asList(nums[0], nums[1], nums[2]));
            return results;
        }
        Arrays.sort(nums);
        // when the smallest element of the nums is gt 0, no solution will be provided.

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                int sum = nums[L] + nums[R] + nums[i];
                if (sum == 0) {
                    results.add(Arrays.asList(nums[L], nums[R], nums[i]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }while (L < R && nums[R] == nums[R - 1]){
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }

        }
        return results;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k
//]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers 
// 👍 10060 👎 1037
