/*
 * @lc app=leetcode id=162 lang=java
 * @lcpr version=20004
 *
 * [162] Find Peak Element
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid + 1] < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,1,3,5,6,4]\n
// @lcpr case=end

 */
