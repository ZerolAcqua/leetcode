/*
 * @lc app=leetcode id=59 lang=java
 * @lcpr version=20004
 *
 * [59] Spiral Matrix II
 */

// @lcpr-template-start
// @lc code=start
class Solution {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int topBound = 0, bottomBound = n - 1;
        int leftBound = 0, rightBound = n - 1;

        int num = 1;
        while (num <= n * n) {
            // to right
            if (topBound <= bottomBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    res[topBound][i] = num++;
                }
                topBound++;
            }

            // to bottom
            if (leftBound <= rightBound) {
                for (int i = topBound; i <= bottomBound; i++) {
                    res[i][rightBound] = num++;
                }
                rightBound--;
            }

            // to left
            if (topBound <= bottomBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    res[bottomBound][i] = num++;
                }
                bottomBound--;
            }

            // to top
            if (leftBound <= rightBound) {
                for (int i = bottomBound; i >= topBound; i--) {
                    res[i][leftBound] = num++;
                }
                leftBound++;
            }
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */
