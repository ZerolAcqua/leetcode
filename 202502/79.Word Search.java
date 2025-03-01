/*
 * @lc app=leetcode id=79 lang=java
 * @lcpr version=30005
 *
 * [79] Word Search
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    boolean found;
    boolean visited[][];
    int m;
    int n;

    int[][] offsets = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                backTracking(board, i, j, word, 0);
                visited[i][j] = false;
            }
        }
        return found;
    }

    private void backTracking(char[][] board, int r, int c, String word, int curCharIdx) {
        if (found == true) {
            return;
        }

        if (curCharIdx >= word.length()) {
            found = false;
            return;
        }

        if (board[r][c] != word.charAt(curCharIdx)) {
            return;
        } else if (curCharIdx == word.length() - 1) {
            found = true;
            return;
        }

        for (int[] offset : offsets) {
            int newR = r + offset[0];
            int newC = c + offset[1];
            if (newR < 0 || newR >= m || newC < 0 || newC >= n) {
                continue;
            }

            if (visited[newR][newC]) {
                continue;
            } else {
                visited[newR][newC] = true;
                backTracking(board, newR, newC, word, curCharIdx + 1);
                visited[newR][newC] = false;
            }
        }
    }
}
// @lc code=end

/*
// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"SEE"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCB"\n
// @lcpr case=end

 */
