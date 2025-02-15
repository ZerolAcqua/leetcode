/*
 * @lc app=leetcode id=236 lang=java
 * @lcpr version=20004
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lcpr-template-start
// @lcpr-template-end
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// @lc code=start
class Solution {

    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    TreeNode find(TreeNode root, int c1, int c2) {
        if (root == null) {
            return null;
        }

        if (root.val == c1 || root.val == c2) {
            return root;
        }

        TreeNode left = find(root.left, c1, c2);
        if (res != null) {
            return left;
        }
        TreeNode right = find(root.right, c1, c2);
        if (res != null) {
            return right;
        }

        if (left != null && right != null) {
            res = root;
            return root;
        }

        return left != null ? left : right;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n1\n
// @lcpr case=end

// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n4\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n2\n
// @lcpr case=end

 */
