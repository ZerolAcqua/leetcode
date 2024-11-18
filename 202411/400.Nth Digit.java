/*
 * @lc app=leetcode id=400 lang=java
 * @lcpr version=20003
 *
 * [400] Nth Digit
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long base = 1;

        while (n > 9 * base * digit) {
            n -= 9 * base * digit;
            base *= 10;
            digit++;
        }

        long val = base + (n - 1) / digit;
        int index = (n - 1) % digit;
        return ("" + val).charAt(index) - '0';
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 11\n
// @lcpr case=end

 */

