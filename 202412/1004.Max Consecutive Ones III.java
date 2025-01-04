/*
 * @lc app=leetcode id=1004 lang=java
 * @lcpr version=20004
 *
 * [1004] Max Consecutive Ones III
 */

// @lcpr-template-start
// @lc code=start
class Solution {

    public int longestOnes(int[] nums, int k) {
        int flipCount = k;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < n) {
            while (right < n && (flipCount > 0 || nums[right] == 1)) {
                if (nums[right] == 0) {
                    flipCount--;
                }
                right++;
            }

            res = Math.max(res, right - left);

            while (flipCount == 0) {
                if (left == right) {
                    left++;
                    right++;
                    break;
                }
                if (nums[left] == 0) {
                    flipCount++;
                }
                left++;
            }

        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,1,1,0,0,0,1,1,1,1,0]\n2\n
// @lcpr case=end

// @lcpr case=start
// [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]\n3\n
// @lcpr case=end

 */
