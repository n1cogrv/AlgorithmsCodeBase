package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

//2021-08-27 16:54:06
//java: Contains Duplicate II
//QuestionId: 219
public class Prbl219ContainsDuplicateII{
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args){
        Solution solution = new Prbl219ContainsDuplicateII().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hMap.containsKey(nums[i])) {
                if (Math.abs(hMap.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            hMap.put(nums[i], i);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//Given an integer array nums and an integer k, return true if there are two 
//distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <
//= k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1
//Output: true
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
// Related Topics Array Hash Table Sliding Window 👍 1615 👎 1522
