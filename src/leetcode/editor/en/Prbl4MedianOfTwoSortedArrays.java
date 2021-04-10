package leetcode.editor.en;

import java.util.logging.Logger;

// TODO: Understand this damn problem
// TODO: https://www.youtube.com/watch?v=LPFhl65R7ww

//2021-04-10 18:09:01
//java: Median of Two Sorted Arrays
//QuestionId: 4
public class Prbl4MedianOfTwoSortedArrays {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl4MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
            int x = nums1.length;
            int y = nums2.length;
            int low = 0;
            int high = x;
            while (low <= high) {
                int partX = (low + high) / 2;
                int partY = (x + y + 1) / 2 - partX;
                int xLeft = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
                int xRight = partX == x ? Integer.MAX_VALUE : nums1[partX];
                int yLeft = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
                int yRight = partY == y ? Integer.MAX_VALUE : nums2[partY];
                if (xLeft <= yRight && yLeft <= xRight) {
                    if ((x + y) % 2 == 0) {
                        return ((double) Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2;
                    } else {
                        return Math.max(xLeft, yLeft);
                    }
                } else if (xLeft > yRight) {
                    high = partX - 1;
                } else {
                    low = partX + 1;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return t
//he median of the two sorted arrays. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0,0], nums2 = [0,0]
//Output: 0.00000
// 
//
// Example 4: 
//
// 
//Input: nums1 = [], nums2 = [1]
//Output: 1.00000
// 
//
// Example 5: 
//
// 
//Input: nums1 = [2], nums2 = []
//Output: 2.00000
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//Follow up: The overall run time complexity should be O(log (m+n)). Related Top
//ics Array Binary Search Divide and Conquer 
// 👍 9694 👎 1489
