package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

//2021-08-27 16:45:35
//java: Contains Duplicate
//QuestionId: 217
public class Prbl217ContainsDuplicate {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl217ContainsDuplicate().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hSet = new HashSet<>();

        for (int num : nums) {
            if (hSet.contains(num)) return true;
            hSet.add(num);
        }
        return false;
    }

//        public boolean containsDuplicate(int[] nums) {
//            if (nums.length == 1) return false;
//            Arrays.sort(nums);
//            for (int i = 1; i < nums.length; i++) {
//                if (nums[i] == nums[i - 1]) {
//                    return true;
//                }
//            }
//            return false;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given an integer array nums, return true if any value appears at least twice 
//in the array, and return false if every element is distinct. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,1]
//Output: true
// Example 2: 
// Input: nums = [1,2,3,4]
//Output: false
// Example 3: 
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics Array Hash Table Sorting 👍 2154 👎 873
