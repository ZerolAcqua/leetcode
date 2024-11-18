/*
 * @lc app=leetcode id=357 lang=java
 * @lcpr version=20003
 *
 * [357] Count Numbers with Unique Digits
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }

        int res = 9;
        for (int i = 1; i < n; i++) {
            res *= (10 - i);
        }

        return res + countNumbersWithUniqueDigits(n - 1);

    }
}
// @lc code=end



/*
// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 0\n
// @lcpr case=end

 */

