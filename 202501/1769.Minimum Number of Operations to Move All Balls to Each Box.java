/*
 * @lc app=leetcode id=1769 lang=java
 * @lcpr version=20004
 *
 * [1769] Minimum Number of Operations to Move All Balls to Each Box
 */

// @lcpr-template-start
// @lc code=start
class Solution {

    public int[] minOperations(String boxes) {
        int left = 0, right = 0;
        int[] res = new int[boxes.length()];

        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                res[0] += i;
                if (i != 0) {
                    right++;
                }
            }

        }
        if (boxes.charAt(0) == '1') {
            left = 1;
        }

        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + left - right;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// "110"\n
// @lcpr case=end

// @lcpr case=start
// "001011"\n
// @lcpr case=end

 */
