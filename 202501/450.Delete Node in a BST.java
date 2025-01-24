/*
 * @lc app=leetcode id=450 lang=java
 * @lcpr version=20004
 *
 * [450] Delete Node in a BST
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode min = getMin(root.right);
            root.right = deleteNode(root.right, min.val);

            min.left = root.left;
            min.right = root.right;
            root = min;

        }

        return root;

    }

    TreeNode getMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
// @lc code=end

/*
// @lcpr case=start

    5,3,6,2,4,null,7]\n3\n
 case=end

// @lcpr case=start
// [5,3,6,2,4,null,7]\n0\n
// @lcpr case=end
// []\n0\n
// @lcpr case=end

 */
