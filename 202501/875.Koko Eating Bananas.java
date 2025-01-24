/*
 * @lc app=leetcode id=875 lang=java
 * @lcpr version=20004
 *
 * [875] Koko Eating Bananas
 */

// @lcpr-template-start
// @lc code=start
class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (f(piles, mid) <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    long f(int[] piles, int speed) {
        long res = 0;
        for (int pile : piles) {
            res += pile / speed + ((pile % speed) > 0 ? 1 : 0);
        }
        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [3,6,7,11]\n8\n
// @lcpr case=end

// @lcpr case=start
// [30,11,23,4,20]\n5\n
// @lcpr case=end

// @lcpr case=start
// [30,11,23,4,20]\n6\n
// @lcpr case=end

 */
