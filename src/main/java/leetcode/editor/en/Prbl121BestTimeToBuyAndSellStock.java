package leetcode.editor.en;

import java.util.logging.Logger;

//2021-04-25 15:56:48
//java: Best Time to Buy and Sell Stock
//QuestionId: 121
public class Prbl121BestTimeToBuyAndSellStock {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl121BestTimeToBuyAndSellStock().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        // Time limit exceeded
        public int maxProfit(int[] prices) {
            int length = prices.length;
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int i = 0; i < length; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                } else if (prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }
            return maxProfit;
        }

        // Time limit exceeded
//        public int maxProfit(int[] prices) {
//            int length = prices.length;
//            int maxProfit = 0;
//            for (int i = 0; i < length - 1; i++) {
//                for (int j = i + 1; j < length; j++) {
//                    if (prices[j] - prices[i] > maxProfit) {
//                        maxProfit = prices[j] - prices[i];
//                    }
//                }
//            }
//            return maxProfit;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//You are given an array prices where prices[i] is the price of a given stock on
// the ith day. 
//
// You want to maximize your profit by choosing a single day to buy one stock an
//d choosing a different day in the future to sell that stock. 
//
// Return the maximum profit you can achieve from this transaction. If you canno
//t achieve any profit, return 0. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must
// buy before you sell.
// 
//
// Example 2: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics Array Dynamic Programming 
// 👍 8297 👎 360

