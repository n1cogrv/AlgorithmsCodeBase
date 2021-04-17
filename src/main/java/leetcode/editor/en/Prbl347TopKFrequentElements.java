//Given a non-empty array of integers, return the k most frequent elements. 
//
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1] 
// 
//
// Note: 
//
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Your algorithm's time complexity must be better than O(n log n), where n is t
//he array's size. 
// It's guaranteed that the answer is unique, in other words the set of the top 
//k frequent elements is unique. 
// You can return the answer in any order. 
// 
// Related Topics Hash Table Heap 
// 👍 4113 👎 243

package leetcode.editor.en;

import java.util.*;

// java: Top K Frequent Elements
public class Prbl347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new Prbl347TopKFrequentElements()
                .new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            int maxFrequency = 0;
            // Key   -> Number itself
            // Value -> Number Occur/freq
            Map<Integer, Integer> num2Freq = new HashMap<>();
            // put element in Map, add value/freq once occurs
            // also keep track of maxfreq
            for (int i = 0; i < nums.length; i++) {
                num2Freq.put(nums[i], num2Freq.getOrDefault(nums[i], 0) + 1);
                maxFrequency = Math.max(maxFrequency, num2Freq.get(nums[i]));
            }

            // Index -> Freq
            // Value -> numbers in each corresponding list
            // because the nums' freq start from 1, so it need +1
            List<Integer>[] freq2Num = new LinkedList[maxFrequency + 1];
            for (int i = 0; i <= maxFrequency; i++) {
                freq2Num[i] = new LinkedList<>();
            }

            // For each number, freq as index, append to coresponding list
            // eg-> [12, 12, 15, 17, 17]
            // freq:2 has following numbers => 12, 17
            for (Integer number : num2Freq.keySet()) {
                freq2Num[num2Freq.get(number)].add(number);
            }

            int[] result = new int[k];
            int currentAnswerCount = 0;
            // from high-freq to 0 freq
            for (int i = maxFrequency; i > 0; i--) {
                for (Integer num : freq2Num[i]) {
                    if (currentAnswerCount < k) {
                        result[currentAnswerCount] = num;
                        currentAnswerCount++;
                    } else {
                        return result;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}