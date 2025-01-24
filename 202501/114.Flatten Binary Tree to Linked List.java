/*
 * @lc app=leetcode id=114 lang=java
 * @lcpr version=20004
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lcpr-template-start
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode node = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode p = root;

        while (p.right != null) {
            p = p.right;
        }
        p.right = node;

    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,5,3,4,null,6]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */
