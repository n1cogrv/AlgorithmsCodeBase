//A frog is crossing a river. The river is divided into some number of units, an
//d at each unit, there may or may not exist a stone. The frog can jump on a stone
//, but it must not jump into the water. 
//
// Given a list of stones' positions (in units) in sorted ascending order, deter
//mine if the frog can cross the river by landing on the last stone. Initially, th
//e frog is on the first stone and assumes the first jump must be 1 unit. 
//
// If the frog's last jump was k units, its next jump must be either k - 1, k, o
//r k + 1 units. The frog can only jump in the forward direction. 
//
// 
// Example 1: 
//
// 
//Input: stones = [0,1,3,5,6,8,12,17]
//Output: true
//Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd 
//stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 unit
//s to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
// 
//
// Example 2: 
//
// 
//Input: stones = [0,1,2,3,4,8,9,11]
//Output: false
//Explanation: There is no way to jump to the last stone as the gap between the 
//5th and 6th stone is too large.
// 
//
// 
// Constraints: 
//
// 
// 2 <= stones.length <= 2000 
// 0 <= stones[i] <= 231 - 1 
// stones[0] == 0 
// 
// Related Topics Dynamic Programming 
// 👍 1467 👎 130

package leetcode.editor.en;

//java: Frog Jump
public class Prbl403FrogJump {
    public static void main(String[] args) {
        Solution solution = new Prbl403FrogJump().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /*
    index:        0   1   2   3   4   5   6   7
            +---+---+---+---+---+---+---+---+
stone pos:  | 0 | 1 | 3 | 5 | 6 | 8 | 12| 17|
            +---+---+---+---+---+---+---+---+
k:        0 | 0 | 1 | 0 | 0 | 1 | 0 | 0 | 0 |
          1 | 1 | 1 | 1 | 1 | 1 | 1 | 0 | 0 |
          2 | 0 | 1 | 1 | 1 | 1 | 1 | 0 | 0 |
          3 | 0 | 0 | 1 | 1 | 1 | 1 | 1 | 0 |
          4 | 0 | 0 | 0 | 0 | 1 | 1 | 1 | 0 |
          5 | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 1 |
          6 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
          7 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
     */

    class Solution {
        public boolean canCross(int[] stones) {
            int N = stones.length;
            boolean[][] dp = new boolean[N][N + 1];
            dp[0][1] = true;
            for (int i = 1; i < N; ++i) {
                for (int j = 0; j < i; ++j) {
                    int diff = stones[i] - stones[j];
                    if (diff > N || !dp[j][diff]) continue;
                    dp[i][diff] = true;
                    if (diff - 1 > 0) dp[i][diff - 1] = true;
                    if (diff + 1 < N) dp[i][diff + 1] = true;
                    if (i == N - 1) return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}