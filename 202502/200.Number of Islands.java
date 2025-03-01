/*
 * @lc app=leetcode id=200 lang=java
 * @lcpr version=30005
 *
 * [200] Number of Islands
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    boolean[][] isVisited;
    int m;
    int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
        int res = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1' && !isVisited[r][c]) {
                    res++;
                    fillIsland(grid, r, c);
                }
            }
        }

        return res;
    }

    void fillIsland(char[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }

        if (grid[r][c] != '1') {
            return;
        }

        if (isVisited[r][c]) {
            return;
        }

        isVisited[r][c] = true;

        fillIsland(grid, r + 1, c);
        fillIsland(grid, r - 1, c);
        fillIsland(grid, r, c + 1);
        fillIsland(grid, r, c - 1);
    }
}
// @lc code=end

/*
// @lcpr case=start
// [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]\n
// @lcpr case=end

// @lcpr case=start
// [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]\n
// @lcpr case=end

 */
