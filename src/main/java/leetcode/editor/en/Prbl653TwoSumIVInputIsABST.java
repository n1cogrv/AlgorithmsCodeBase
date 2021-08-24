package leetcode.editor.en;

import xyz.mijazz.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

//2021-08-23 21:14:31
//java: Two Sum IV - Input is a BST
//QuestionId: 653
public class Prbl653TwoSumIVInputIsABST {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl653TwoSumIVInputIsABST().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        private int k = 0;

        private Map<Integer, TreeNode> targets = new HashMap<>();

        private boolean flag = false;

        public boolean findTarget(TreeNode root, int k) {
            this.k = k;
            addHelper(root);
            judgeHelper(root);
            return flag;
        }

        public void addHelper(TreeNode root) {
            if (root != null) {
                targets.put(root.val, root);
            }
            if (root.left != null) addHelper(root.left);
            if (root.right != null) addHelper(root.right);
        }

        public void judgeHelper(TreeNode root) {
            if (root == null) return;

            int need = k - root.val;
            if (targets.containsKey(need) && targets.get(need) != root) flag = true;
            if (root.left != null) judgeHelper(root.left);
            if (root.right != null) judgeHelper(root.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given the root of a Binary Search Tree and a target number k, return true if 
//there exist two elements in the BST such that their sum is equal to the given 
//target. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,3,6,2,4,null,7], k = 9
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,7], k = 28
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = [2,1,3], k = 4
//Output: true
// 
//
// Example 4: 
//
// 
//Input: root = [2,1,3], k = 1
//Output: false
// 
//
// Example 5: 
//
// 
//Input: root = [2,1,3], k = 3
//Output: true
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root is guaranteed to be a valid binary search tree. 
// -10⁵ <= k <= 10⁵ 
// 
// Related Topics Hash Table Two Pointers Tree Depth-First Search Breadth-First 
//Search Binary Search Tree Binary Tree 👍 2479 👎 168
