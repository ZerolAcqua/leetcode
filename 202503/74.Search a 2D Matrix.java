/*
 * @lc app=leetcode id=74 lang=java
 * @lcpr version=30005
 *
 * [74] Search a 2D Matrix
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getValue(matrix, mid) < target) {
                left = mid + 1;
            } else if (getValue(matrix, mid) > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;

    }

    private int getValue(int[][] matrix, int idx) {
        int n = matrix[0].length;
        return matrix[idx / n][idx % n];
    }

}
// @lc code=end

/*
// @lcpr case=start
// [[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3\n
// @lcpr case=end

// @lcpr case=start
// [[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n13\n
// @lcpr case=end

 */
