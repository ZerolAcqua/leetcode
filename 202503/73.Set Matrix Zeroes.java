/*
 * @lc app=leetcode id=73 lang=java
 * @lcpr version=30005
 *
 * [73] Set Matrix Zeroes
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    public void setZeroes(int[][] matrix) {
        boolean firstColHasZero = false;

        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
            }

            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = r - 1; i >= 0; i--) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (firstColHasZero) {
                matrix[i][0] = 0;
            }
        }
    }
}
// @lc code=end

/*
// @lcpr case=start
// [[1,1,1],[1,0,1],[1,1,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,1,2,0],[3,4,5,2],[1,3,1,5]]\n
// @lcpr case=end

 */
