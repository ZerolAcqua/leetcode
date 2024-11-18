/*
 * @lc app=leetcode id=67 lang=java
 * @lcpr version=20003
 *
 * [67] Add Binary
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        StringBuilder res = new StringBuilder();

        int m = a.length();
        int n = b.length();

        int carry = 0;
        int i = 0;

        while (i < Math.max(m, n) || carry != 0) {
            carry += i < m ? (a.charAt(i) - '0') : 0;
            carry += i < n ? (b.charAt(i) - '0') : 0;
            res.append(carry % 2);
            carry /= 2;
            i++;
        }
        return res.reverse().toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// "11"\n"1"\n
// @lcpr case=end

// @lcpr case=start
// "1010"\n"1011"\n
// @lcpr case=end

 */

