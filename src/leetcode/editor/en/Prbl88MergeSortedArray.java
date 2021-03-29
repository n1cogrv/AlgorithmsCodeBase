//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. You may assume that nums1 has a size equal to m + n such that it has enough s
//pace to hold additional elements from nums2. 
//
// 
// Example 1: 
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
// Example 2: 
// Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
// 
// 
// Constraints: 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics Array Two Pointers 
// 👍 3568 👎 5148

package leetcode.editor.en;
//java: Merge Sorted Array
public class Prbl88MergeSortedArray{
    public static void main(String[] args){
        Solution solution = new Prbl88MergeSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1_tail = m - 1;
        int num2_tail = n - 1;
        int backward_cursor = m + n - 1;
        while (num1_tail >= 0 && num2_tail >= 0) {
            nums1[backward_cursor] = Math.max(nums1[num1_tail--], nums2[num2_tail--]);
            backward_cursor--;
        }
        while (num2_tail >= 0) {
            nums1[backward_cursor] = nums2[num2_tail];
            backward_cursor--;
            num2_tail--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}