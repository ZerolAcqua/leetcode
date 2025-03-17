/*
 * @lc app=leetcode id=283 lang=java
 * @lcpr version=30103
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;

        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while (slow < n) {
            nums[slow] = 0;
            slow++;
        }
    }
}
// @lc code=end

/*
// @lcpr case=start
// [0,1,0,3,12]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */
