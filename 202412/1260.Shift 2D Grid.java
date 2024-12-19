/*
 * @lc app=leetcode id=1260 lang=java
 * @lcpr version=20004
 *
 * [1260] Shift 2D Grid
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        List<List<Integer>> res = new ArrayList<>(r);

        for (int i = 0; i < r; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                rowList.add(0); 
            }
            res.add(rowList);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int oriIdx = i * c + j;
                int newIdx = (oriIdx + k) % (r * c);
                int newR = newIdx / c;
                int newC = newIdx - newR * c;
                res.get(newR).set(newC, grid[i][j]);
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,2,3],[4,5,6],[7,8,9]]\n1\n
// @lcpr case=end

// @lcpr case=start
// [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]]\n4\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3],[4,5,6],[7,8,9]]\n9\n
// @lcpr case=end

 */

