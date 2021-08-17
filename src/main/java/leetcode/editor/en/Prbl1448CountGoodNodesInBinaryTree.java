package leetcode.editor.en;

import javax.swing.tree.TreeNode;
import java.util.logging.Logger;

//2021-08-17 16:45:11
//java: Count Good Nodes in Binary Tree
//QuestionId: 1448
public class Prbl1448CountGoodNodesInBinaryTree {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Solution solution = new Prbl1448CountGoodNodesInBinaryTree().new Solution();
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

        private int goodNodeCount = 0;

        public int goodNodes(TreeNode root) {
            return recursiveHelper(root, Integer.MIN_VALUE);
        }

        public int recursiveHelper(TreeNode root, int previousVal) {
            if (root == null) return 0;

            if (root.val >= previousVal) ++goodNodeCount;

            recursiveHelper(root.left, Math.max(root.val, previousVal));
            recursiveHelper(root.right, Math.max(root.val, previousVal));

            return goodNodeCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//Given a binary tree root, a node X in the tree is named good if in the path 
//from root to X there are no nodes with a value greater than X. 
//
// Return the number of good nodes in the binary tree. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [3,1,4,3,null,1,5]
//Output: 4
//Explanation: Nodes in blue are good.
//Root Node (3) is always a good node.
//Node 4 -> (3,4) is the maximum value in the path starting from the root.
//Node 5 -> (3,4,5) is the maximum value in the path
//Node 3 -> (3,1,3) is the maximum value in the path. 
//
// Example 2: 
//
// 
//
// 
//Input: root = [3,3,null,4,2]
//Output: 3
//Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it. 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: 1
//Explanation: Root is considered as good. 
//
// 
// Constraints: 
//
// 
// The number of nodes in the binary tree is in the range [1, 10^5]. 
// Each node's value is between [-10^4, 10^4]. 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 12
//81 👎 49
