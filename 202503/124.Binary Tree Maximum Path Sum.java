/*
 * @lc app=leetcode id=124 lang=java
 * @lcpr version=30005
 *
 * [124] Binary Tree Maximum Path Sum
 */

// @lcpr-template-start
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

class Solution {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSubPath(root);
        return res;
    }

    private int maxSubPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = maxSubPath(node.left);
        int right = maxSubPath(node.right);

        res = Math.max(res, left + right + node.val);
        return Math.max(Math.max(left, right) + node.val, 0);
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [-10,9,20,null,null,15,7]\n
// @lcpr case=end

 */
