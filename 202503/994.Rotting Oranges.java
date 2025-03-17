/*
 * @lc app=leetcode id=994 lang=java
 * @lcpr version=30005
 *
 * [994] Rotting Oranges
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int step = 0;
        int left = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    left++;
                }
            }
        }

        int[][] dirs = { { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 } };

        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();

                for (int[] dir : dirs) {
                    int nx = pos[0] + dir[0];
                    int ny = pos[1] + dir[1];
                    if(nx < 0 || nx >= m || ny< 0 || ny >= n) {
                        continue;
                    }

                    if (grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        left--;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        if (left > 0) {
            return -1;
        }

        if(step == 0) {
            return 0;
        }

        return step - 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[2,1,1],[1,1,0],[0,1,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[2,1,1],[0,1,1],[1,0,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,2]]\n
// @lcpr case=end

 */

