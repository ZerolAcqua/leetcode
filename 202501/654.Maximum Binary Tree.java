/*
 * @lc app=leetcode id=654 lang=java
 * @lcpr version=20004
 *
 * [654] Maximum Binary Tree
 */

// @lcpr-template-start
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);

    }

    // [low,high]
    TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = low; i <= high; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }

        TreeNode res = new TreeNode(max);

        res.left = build(nums, low, idx - 1);
        res.right = build(nums, idx + 1, high);

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [3,2,1,6,0,5]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,1]\n
// @lcpr case=end

 */
