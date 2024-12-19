/*
 * @lc app=leetcode id=54 lang=java
 * @lcpr version=20004
 *
 * [54] Spiral Matrix
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int topBound = 0, bottomBound = m - 1;
        int leftBound = 0, rightBound = n - 1;

        while (res.size() < m * n) {
            // to right
            if (topBound <= bottomBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    res.add(matrix[topBound][i]);
                }
                topBound++;
            }

            // to bottom
            if (leftBound <= rightBound) {
                for (int i = topBound; i <= bottomBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }

            // to left
            if (topBound <= bottomBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    res.add(matrix[bottomBound][i]);
                }
                bottomBound--;
            }

            // to top
            if (leftBound <= rightBound) {
                for (int i = bottomBound; i >= topBound; i--) {
                    res.add(matrix[i][leftBound]);
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
// [[1,2,3],[4,5,6],[7,8,9]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3,4],[5,6,7,8],[9,10,11,12]]\n
// @lcpr case=end

 */

