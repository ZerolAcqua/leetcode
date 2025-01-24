/*
 * @lc app=leetcode id=230 lang=java
 * @lcpr version=20004
 *
 * [230] Kth Smallest Element in a BST
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
    int res = 0;
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
         traverse(root,k);
         return res;
    }

    void traverse(TreeNode root, int k) {
        if(root == null) {
            return ;
        }

        traverse(root.left,k);

        rank++;
        if(rank == k) {
            res = root.val;
            return;
        }

        traverse(root.right,k);

    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,1,4,null,2]\n1\n
// @lcpr case=end

// @lcpr case=start
// [5,3,6,2,4,null,null,1]\n3\n
// @lcpr case=end

 */

