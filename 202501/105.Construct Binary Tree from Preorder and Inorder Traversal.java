/*
 * @lc app=leetcode id=105 lang=java
 * @lcpr version=20004
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lcpr-template-start
import java.util.*;
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

    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    // [low,high]
    TreeNode build(int[] preorder, int preLow, int preHigh,
            int[] inorder, int inLow, int inHigh) {

        if (preLow > preHigh) {
            return null;
        }

        int root = preorder[preLow];

        // search root in inorder
        int inIdx = map.get(root);

        // split the left and the right child trees in inorder
        int leftSize = inIdx - inLow;
        int rightSize = inHigh - inIdx;

        TreeNode res = new TreeNode(root);

        res.left = build(preorder, preLow + 1, preLow + leftSize,
                inorder, inLow, inIdx - 1);
        res.right = build(preorder, preLow + leftSize + 1, preHigh,
                inorder, inIdx + 1, inHigh);

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [3,9,20,15,7]\n[9,3,15,20,7]\n
// @lcpr case=end

// @lcpr case=start
// [-1]\n[-1]\n
// @lcpr case=end

 */
