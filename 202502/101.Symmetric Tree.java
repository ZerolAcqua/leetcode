/*
 * @lc app=leetcode id=101 lang=java
 * @lcpr version=30005
 *
 * [101] Symmetric Tree
 */


// @lcpr-template-start
// @lcpr-template-end

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

// @lc code=start
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTrees(root.left, root.right);
    }

    boolean isSymmetricTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 != null && t2 != null && t1.val == t2.val) {
            return isSymmetricTrees(t1.left, t2.right) && isSymmetricTrees(t1.right, t2.left);
        }

        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,2,3,4,4,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,2,null,3,null,3]\n
// @lcpr case=end

 */

