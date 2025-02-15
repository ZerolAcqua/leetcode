/*
 * @lc app=leetcode id=222 lang=java
 * @lcpr version=20004
 *
 * [222] Count Complete Tree Nodes
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int low, high;
        if (p.val > q.val) {
            low = q.val;
            high = p.val;
        } else {
            low = p.val;
            high = q.val;
        }

        return find(root, low, high);
    }

    TreeNode find(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val >= low && root.val <= high) {
            return root;
        } else if (root.val < low) {
            return find(root.right, low, high);
        } else {
            return find(root.left, low, high);
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5,6]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */
