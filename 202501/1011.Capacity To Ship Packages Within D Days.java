/*
 * @lc app=leetcode id=1011 lang=java
 * @lcpr version=20004
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lcpr-template-start
// @lc code=start
class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 500 * 5 * 10000;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (f(weights, mid) <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    int f(int[] weights, int x) {
        int res = 1;
        int cap = x;
        for (int weight : weights) {
            if (x < weight) {
                return Integer.MAX_VALUE;
            }
            if (cap >= weight) {
                cap -= weight;
            } else {
                cap = x - weight;
                res++;
            }
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,3,4,5,6,7,8,9,10]\n5\n
// @lcpr case=end

// @lcpr case=start
// [3,2,2,4,1,4]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,1,1]\n4\n
// @lcpr case=end

 */
