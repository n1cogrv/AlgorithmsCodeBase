//Given a sorted array nums, remove the duplicates in-place such that each eleme
//nt appears only once and returns the new length. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// Clarification: 
//
// Confused why the returned value is an integer but your answer is an array? 
//
// Note that the input array is passed in by reference, which means a modificati
//on to the input array will be known to the caller as well. 
//
// Internally you can think of this: 
//
// 
//// nums is passed in by reference. (i.e., without making a copy)
//int len = removeDuplicates(nums);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len element
//s.
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//} 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output: 2, nums = [1,2]
//Explanation: Your function should return length = 2, with the first two elemen
//ts of nums being 1 and 2 respectively. It doesn't matter what you leave beyond t
//he returned length.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4]
//Explanation: Your function should return length = 5, with the first five eleme
//nts of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter 
//what values are set beyond the returned length.
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums is sorted in ascending order. 
// 
// Related Topics Array Two Pointers 
// 👍 3727 👎 6752

package leetcode.editor.en;

import java.util.Arrays;
import java.util.stream.Stream;

//java: Remove Duplicates from Sorted Array
public class Prbl26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Prbl26RemoveDuplicatesFromSortedArray().new Solution();
        solution.removeDuplicates(new int[]{1, 1, 2, 4, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int duplicates = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    duplicates++;
                }

                nums[i - duplicates] = nums[i];
            }
            return nums.length - duplicates;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}