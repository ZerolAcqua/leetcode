/*
 * @lc app=leetcode id=34 lang=java
 * @lcpr version=30100
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        int n = nums.length;

        int left = leftBound(nums, target);
        if (left < 0 || left >= n || nums[left] != target) {
            return res;
        }
        int right = rightBound(nums, target);

        res[0] = left;
        res[1] = right;
        return res;

    }

    private int leftBound(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private int rightBound(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }
}

// @lc code=end
/*
// @lcpr case=start
// [5,7,7,8,8,10]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,7,7,8,8,10]\n6\n
// @lcpr case=end

// @lcpr case=start
// []\n0\n
// @lcpr case=end

 */
