/*
 * @lc app=leetcode id=1658 lang=java
 * @lcpr version=20004
 *
 * [1658] Minimum Operations to Reduce X to Zero
 */

// @lcpr-template-start
// @lc code=start
class Solution {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;

        for (int i : nums) {
            sum += i;
        }

        if (x > sum) {
            return -1;
        } else if (x == sum) {
            return n;
        }

        int expect = sum - x;

        int maxLength = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;
        int windowSum = 0;

        while (right < n) {
            windowSum += nums[right];
            right++;

            while (windowSum > expect && left < right) {
                windowSum -= nums[left];
                left++;
            }

            if (windowSum == expect) {
                maxLength = Math.max(maxLength, right - left);
            }
        }

        return maxLength == Integer.MIN_VALUE ? -1 : n - maxLength;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,1,4,2,3]\n5\n
// @lcpr case=end

// @lcpr case=start
// [5,6,7,8,9]\n4\n
// @lcpr case=end

// @lcpr case=start
// [3,2,20,1,1,3]\n10\n
// @lcpr case=end

 */
