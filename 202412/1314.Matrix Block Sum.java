/*
 * @lc app=leetcode id=1314 lang=java
 * @lcpr version=20004
 *
 * [1314] Matrix Block Sum
 */


// @lcpr-template-start
// @lc code=start
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        NumMatrix numMat = new NumMatrix(mat);
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = Math.max(i - k, 0);
                int x2 = Math.min(i + k, m - 1);
                int y1 = Math.max(j - k, 0);
                int y2 = Math.min(j + k, n - 1);

                res[i][j] = numMat.sumRegion(x1, x2, y1, y2);
            }
        }
        return res;
    }
}

class NumMatrix {
    private int[][] preSum;

    public NumMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        preSum = new int[m + 1][n + 1];

        int[][] preSumMat = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i][j - 1] + preSum[i - 1][j] + mat[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }

    }

    // 闭区间，同时换算到 0-base 索引
    public int sumRegion(int x1, int x2, int y1, int y2) {
        return preSum[x2 + 1][y2 + 1] + preSum[x1][y1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1];
    }

}
// @lc code=end



/*
// @lcpr case=start
// [[1,2,3],[4,5,6],[7,8,9]]\n1\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3],[4,5,6],[7,8,9]]\n2\n
// @lcpr case=end

 */

