/*
 * @lc app=leetcode id=306 lang=java
 * @lcpr version=20003
 *
 * [306] Additive Number
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {

        int n = num.length();
        for (int i = 1; i <= n; i++) {
            String first = num.substring(0, i);
            for (int j = i + 1; j <= n; j++) {
                String second = num.substring(i, j);
                if (isValid(num, first, second))
                    return true;
            }
        }
        return false;

    }

    boolean isValid(String num, String first, String second) {
        if (first.startsWith("0") && first.length() > 1
                || second.startsWith("0") && second.length() > 1) {
            return false;
        }

        String numStr = strAdd(first, second);
        String nextStr = num.substring(first.length() + second.length());
        
        if (!nextStr.startsWith(numStr)) {
            return false;
        }
        if (nextStr.equals(numStr)) {
            return true;
        }

        return isValid(num.substring(first.length()), second, numStr);
    }

    String strAdd(String a, String b) {
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
            res.append(carry % 10);
            carry /= 10;
            i++;
        }
        return res.reverse().toString();
    }
}

// @lc code=end



/*
// @lcpr case=start
// "112358"\n
// @lcpr case=end

// @lcpr case=start
// "199100199"\n
// @lcpr case=end

 */

