/*
 * @lc app=leetcode id=102 lang=java
 * @lcpr version=30005
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// @lc code=start
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        LinkedList<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<List<TreeNode>> q = new LinkedList<>();

        List<TreeNode> tmp = new LinkedList<TreeNode>();
        tmp.add(root);
        q.offer(tmp);

        while (!q.isEmpty()) {
            List<TreeNode> nodes = q.poll();
            List<TreeNode> level = new LinkedList<>();
            List<Integer> levelNum = new LinkedList<>();

            for (TreeNode node : nodes) {
                levelNum.add(node.val);
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                }
            }

            res.add(levelNum);
            if (!level.isEmpty()) {
                q.offer(level);
            }
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [3,9,20,null,null,15,7]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */
