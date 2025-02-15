/*
 * @lc app=leetcode id=235 lang=java
 * @lcpr version=20004
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


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
// [6,2,8,0,4,7,9,null,null,3,5]\n2\n8\n
// @lcpr case=end

// @lcpr case=start
// [6,2,8,0,4,7,9,null,null,3,5]\n2\n4\n
// @lcpr case=end

// @lcpr case=start
// [2,1]\n2\n1\n
// @lcpr case=end

 */

