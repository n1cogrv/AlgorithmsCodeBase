package leetcode.editor.en;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.IntStream;

//2021-04-13 16:50:44
//java: Permutations
//QuestionId: 46
// TODO: https://www.youtube.com/watch?v=idmgLLNIC2U
// No fucking idea of why recursive solution works......  Apr 13, 2021
public class Prbl46Permutations {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl46Permutations().new Solution();
        int[] testCase = IntStream.range(1, 4).toArray();
        logger.info(Arrays.toString(testCase));
        logger.info(solution.permute(testCase).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) return Collections.emptyList();
            List<List<Integer>> result = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            List<Integer> permutation = new ArrayList<>();
            helper(nums, result, used, permutation);
            return result;
        }

        private void helper(int[] nums, List<List<Integer>> result, boolean[] used, List<Integer> permutation) {
            if (permutation.size() == nums.length) {
                result.add(new ArrayList<>(permutation));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                permutation.add(nums[i]);
                helper(nums, result, used, permutation);
                permutation.remove(permutation.size() - 1);
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given an array nums of distinct integers, return all the possible permutations
//. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics Backtracking 
// 👍 5779 👎 134
