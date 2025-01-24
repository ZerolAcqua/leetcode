/*
 * @lc app=leetcode id=652 lang=java
 * @lcpr version=20004
 *
 * [652] Find Duplicate Subtrees
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

    HashMap<TreeNode, String> memo = new HashMap<>();
    HashMap<String, Integer> subtreeCount = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        String left = serialize(root.left);
        String right = serialize(root.right);
        String myself = left + "," + right + "," + root.val;
        memo.put(root, myself);

        int freq = subtreeCount.getOrDefault(myself, 0);
        if (freq == 1) {
            res.add(root);
        }

        subtreeCount.put(myself, freq + 1);

        return myself;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,3,4,null,2,4,null,null,4]\n
// @lcpr case=end

// @lcpr case=start
// [2,1,1]\n
// @lcpr case=end

// @lcpr case=start
// [2,2,2,3,null,3,null]\n
// @lcpr case=end

 */
