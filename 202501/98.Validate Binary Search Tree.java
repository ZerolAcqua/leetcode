/*
 * @lc app=leetcode id=98 lang=java
 * @lcpr version=20004
 *
 * [98] Validate Binary Search Tree
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

// @lc code=start
class Solution {

    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root, null, null);

    }

    boolean _isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }

        if (!_isValidBST(root.left, min, root) || !_isValidBST(root.right, root, max)) {
            return false;
        }

        return true;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [5,1,4,null,null,3,6]\n
// @lcpr case=end

 */
