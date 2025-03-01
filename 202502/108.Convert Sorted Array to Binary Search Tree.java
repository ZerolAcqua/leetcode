/*
 * @lc app=leetcode id=108 lang=java
 * @lcpr version=30005
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
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

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        return new TreeNode(
                nums[mid],
                sortedArrayToBST(nums, low, mid - 1),
                sortedArrayToBST(nums, mid + 1, high));
    }
}
// @lc code=end

/*
// @lcpr case=start
// [-10,-3,0,5,9]\n
// @lcpr case=end

// @lcpr case=start
// [1,3]\n
// @lcpr case=end

 */
