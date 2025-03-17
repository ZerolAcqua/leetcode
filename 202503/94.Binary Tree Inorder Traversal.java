/*
 * @lc app=leetcode id=94 lang=java
 * @lcpr version=30005
 *
 * [94] Binary Tree Inorder Traversal
 */


// @lcpr-template-start
import java.util.*;
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
    
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        tranverse(root);
        return res;
    }

    private void tranverse(TreeNode root) {
        if(root==null) {
            return;
        }

        tranverse(root.left);
        res.add(root.val);
        tranverse(root.right);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,null,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,null,8,null,null,6,7,9]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

