/*
 * @lc app=leetcode id=410 lang=java
 * @lcpr version=20004
 *
 * [410] Split Array Largest Sum
 */

// @lcpr-template-start
// @lc code=start
class Solution {

    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (f(nums, mid) <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int f(int nums[], int x) {
        int res = 1;
        int cap = x;
        for (int num : nums) {
            if (x < num) {
                return Integer.MAX_VALUE;
            }
            if (cap >= num) {
                cap -= num;
            } else {
                cap = x - num;
                res++;
            }
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [7,2,5,10,8]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

 */
