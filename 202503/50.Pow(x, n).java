/*
 * @lc app=leetcode id=50 lang=java
 * @lcpr version=30103
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return recursePow(1 / x, Integer.MAX_VALUE) / x;
            } else {
                return recursePow(1 / x, -n);
            }
        } else {
           return recursePow(x, n);
        }
    }

    private double recursePow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double temp = recursePow(x, n / 2);

        if (n % 2 == 1) {
            return temp * temp * x;
        } else {
            return temp * temp;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 2.00000\n10\n
// @lcpr case=end

// @lcpr case=start
// 2.10000\n3\n
// @lcpr case=end

// @lcpr case=start
// 2.00000\n-2\n
// @lcpr case=end

 */

