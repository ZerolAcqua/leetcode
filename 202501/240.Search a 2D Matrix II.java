/*
 * @lc app=leetcode id=240 lang=java
 * @lcpr version=20004
 *
 * [240] Search a 2D Matrix II
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int i = 0, j = c - 1;
        while (i >= 0 && i < r && j >= 0 && j < c) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }

        return false;

    }
}
// @lc code=end

/*
// @lcpr case=start
// [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n5\n
// @lcpr case=end

// @lcpr case=start
// [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n20\n
// @lcpr case=end

 */
