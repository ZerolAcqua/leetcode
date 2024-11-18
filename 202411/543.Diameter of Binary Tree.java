/*
 * @lc app=leetcode id=543 lang=java
 * @lcpr version=20003
 *
 * [543] Diameter of Binary Tree
 */

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

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        LRD(root);
        return res;
    }

    private int LRD(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = LRD(root.left);
        int right = LRD(root.right);

        res = Math.max(left + right, res);

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
