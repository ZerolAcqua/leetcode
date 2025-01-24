/*
 * @lc app=leetcode id=95 lang=java
 * @lcpr version=20004
 *
 * [95] Unique Binary Search Trees II
 */


// @lcpr-template-start
import java.util.List;
import java.util.LinkedList;
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
    public List<TreeNode> generateTrees(int n) {
        return build(1,n); 
    }

    List<TreeNode> build( int low, int high) {

        List<TreeNode> res = new LinkedList<>();

        if(low > high) {
            res.addLast(null);
            return res;
        }

        for(int idx = low; idx <= high; idx++) {
            List<TreeNode> leftTrees = build(low,idx - 1);
            List<TreeNode> rightTrees = build(idx + 1,high);

            for(TreeNode left :leftTrees ){
                for(TreeNode right :rightTrees ){
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    res.addLast(root);
                }
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

