/*
 * @lc app=leetcode id=8 lang=java
 * @lcpr version=20003
 *
 * [8] String to Integer (atoi)
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        long res = 0L;
        boolean isPositive = true;

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) {
            return 0;
        }

        if (s.charAt(i) == '-') {
            isPositive = false;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        while (i < n && res <= Integer.MAX_VALUE + 2L && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            System.out.println(i);
            res = res * 10 + s.charAt(i) - '0';
            i++;
        }

        if (isPositive && res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (!isPositive && -res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return isPositive ? (int) res : (int) -res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "42"\n
// @lcpr case=end

// @lcpr case=start
// " -042"\n
// @lcpr case=end

// @lcpr case=start
// "1337c0d3"\n
// @lcpr case=end

// @lcpr case=start
// "0-1"\n
// @lcpr case=end

// @lcpr case=start
// "words and 987"\n
// @lcpr case=end

 */

