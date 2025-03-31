/*
 * @lc app=leetcode id=543 lang=java
 * @lcpr version=30103
 *
 * [543] Diameter of Binary Tree
 */

// @lc code=start
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        res = Math.max(res, left + right);

        return Math.max(left, right) + 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

 */

