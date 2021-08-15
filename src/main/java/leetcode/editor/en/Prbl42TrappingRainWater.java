package leetcode.editor.en;

import java.util.Arrays;
import java.util.logging.Logger;

//2021-08-15 15:46:07
//java: Trapping Rain Water
//QuestionId: 42
public class Prbl42TrappingRainWater {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl42TrappingRainWater().new Solution();
        int[] s = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        logger.info(Arrays.toString(s));

        solution.trap(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            if (n < 3) return 0;

            int sum = 0;
            // Find the peak index.
            int peakIdx = 0;
            for (int i = 0; i < n; i++) {
                if (height[i] > height[peakIdx]) {
                    peakIdx = i;
                }
            }

            int leftPeak = 0;
            for (int i = 1; i <= peakIdx; i++) {
                if (height[i] >= height[leftPeak]) {
                    // distance(Current_idx, Temp_peak_idx) * height
                    // sum the area of that rectangle.
                    sum += (i - leftPeak - 1) * height[leftPeak];
                    leftPeak = i;
                } else {
                    // Get rid of those blocks in the middle that doesn't
                    // count as water.
                    sum -= height[i];
                }
            }

            int rightPeak = n - 1;
            for (int i = n - 2; i >= peakIdx; i--) {
                if (height[i] >= height[rightPeak]) {
                    // distance(Current_idx, Temp_peak_idx) * height
                    // sum the area of that rectangle.
                    sum += (rightPeak - i - 1) * height[rightPeak];
                    rightPeak = i;
                } else {
                    // Get rid of those blocks in the middle that doesn't
                    // count as water.
                    sum -= height[i];
                }
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
//
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are
// being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack 
// 👍 13366 👎 189
