/*
 * @lc app=leetcode id=9 lang=cpp
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
public:
    bool isPalindrome(int x) {
        // 负数不是回文数
        if (x < 0)
        {
            return false;
        }
        long y = 0;
        int nTemp = x;
        while (nTemp > 0)
        {
            // 取出 x 的最后一位，作为 y 的最高位
            y = y * 10 + nTemp % 10;
            nTemp = nTemp / 10;
        }
        return y == x;
    }
};
// @lc code=end

