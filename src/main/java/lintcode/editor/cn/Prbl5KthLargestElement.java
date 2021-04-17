package lintcode.editor.cn;/**
 * @Time 2021-04-06 4:16 PM
 * @Author MijazzChan
 */

import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Prbl5KthLargestElement {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 9, 10, 34};
        Stream.of(3, 1).map(
                instance -> new Prbl5KthLargestElement().new Solution().kthLargestElement(instance, nums)
        ).forEach(System.out::println);
    }

    class Solution {
        public int kthLargestElement(int n, int[] nums) {
            PriorityQueue<Integer> q = new PriorityQueue<Integer>(nums.length, Integer::compareTo);
            for (int i : nums) {
                q.offer(i);
                if (q.size() > n) {
                    q.poll();
                }
            }
            return q.peek();
        }
    }
}
