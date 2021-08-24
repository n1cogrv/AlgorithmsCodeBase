package leetcode.editor.en;

import java.util.logging.Logger;
import java.util.stream.IntStream;

//2021-08-20 14:12:40
//java: Container With Most Water
//QuestionId: 11
public class Prbl11ContainerWithMostWater {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl11ContainerWithMostWater().new Solution();
        int[] testcase = IntStream.of(1, 8, 6, 2, 5, 4, 8, 3, 7).toArray();
        System.out.println(solution.maxArea(testcase));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;

            // 1e5*1e4?
            int waterHeld = 0;

            while (left < right) {
                waterHeld = Math.max(
                        waterHeld,
                        (right - left) * Math.min(height[left], height[right])
                );
                if (height[left] < height[right]) {
                    ++left;
                } else {
                    --right;
                }
            }

            return waterHeld;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given n non-negative integers a1, a2, ..., an , where each represents a point 
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints 
//of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the 
//x-axis forms a container, such that the container contains the most water. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can 
//contain is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: height = [4,3,2,1,4]
//Output: 16
// 
//
// Example 4: 
//
// 
//Input: height = [1,2,1]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
// Related Topics Array Two Pointers Greedy 👍 11245 👎 768
