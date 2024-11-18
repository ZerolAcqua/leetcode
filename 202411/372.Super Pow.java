/*
 * @lc app=leetcode id=372 lang=java
 * @lcpr version=20002
 *
 * [372] Super Pow
 */

// @lcpr-template-start
// @lcpr-template-end
class Solution {
    int base = 1337;

    int myMulti(int a, int b) {
        return (a * b) % base;
    }

    int myPow(int a, int k) {
        if (k == 0) {
            return 1;
        }

        if (k % 2 == 1) {
            return myMulti(a, myPow(a, k - 1));
        } else {
            int tmp = myPow(a, k / 2);
            return myMulti(tmp, tmp);
        }
    }

    public int superPow(int a, int[] b) {
        a %= base;
        int res = 1;
        for (int i : b) {
            res = myPow(res, 10);
            res = myMulti(res, myPow(a, i));
        }

        return res;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n[3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 2\n[1,0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n[4,3,3,8,5,2]\n
 * // @lcpr case=end
 * 
 */
