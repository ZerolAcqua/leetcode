/*
 * @lc app=leetcode id=538 lang=java
 * @lcpr version=20004
 *
 * [538] Convert BST to Greater Tree
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

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.right);

        root.val += sum;
        sum = root.val;

        traverse(root.left);
    }
}
// @lc code=end

/*
// @lcpr case=start
// [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]\n
// @lcpr case=end

// @lcpr case=start
// [0,null,1]\n
// @lcpr case=end

 */
