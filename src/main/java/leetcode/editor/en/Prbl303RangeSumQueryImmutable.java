package leetcode.editor.en;

import java.util.logging.Logger;
import java.util.stream.Stream;

//2021-08-17 03:22:22
//java: Range Sum Query - Immutable
//QuestionId: 303
public class Prbl303RangeSumQueryImmutable {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        NumArray solution = new Prbl303RangeSumQueryImmutable().new NumArray(
                new int[]{-2, 0, 3, -5, 2, -1}
        );
        Stream.of(new int[]{0, 2}, new int[]{2, 5}, new int[]{0, 5})
                .forEach(testCase -> {
                    System.out.println(solution.sumRange(testCase[0], testCase[1]));
                });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        // Yet to be instantiated inside constructor.
        private int[] SUM_ARRAY;

        public NumArray(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] = nums[i] + nums[i - 1];
            }
            SUM_ARRAY = nums;
            // SUM_ARRAY will be a accumulative array
            // containing data of a0, S1, S2, ... , Sn
        }

        // To retrieve a2+ ... +a5
        // S5 = a0 + a1 + ... + a5
        // S1 = a0 + a1
        // So a2+...+a5 = S5 - S1 in this case SUM_ARRAY[5] - SUM_ARRAY[2 - 1]
        public int sumRange(int left, int right) {
            if (left == 0) return SUM_ARRAY[right];
            return SUM_ARRAY[right] - SUM_ARRAY[left - 1];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

//Given an integer array nums, handle multiple queries of the following type: 
//
// 
// Calculate the sum of the elements of nums between indices left and right 
//inclusive where left <= right. 
// 
//
// Implement the NumArray class: 
//
// 
// NumArray(int[] nums) Initializes the object with the integer array nums. 
// int sumRange(int left, int right) Returns the sum of the elements of nums 
//between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + 
//nums[right]). 
// 
//
// 
// Example 1: 
//
// 
//Input
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//Output
//[null, 1, -1, -3]
//
//Explanation
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
//numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
//numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 0 <= left <= right < nums.length 
// At most 10⁴ calls will be made to sumRange. 
// 
// Related Topics Array Design Prefix Sum 👍 1521 👎 1461
