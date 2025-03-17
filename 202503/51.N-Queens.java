/*
 * @lc app=leetcode id=51 lang=java
 * @lcpr version=30005
 *
 * [51] N-Queens
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    StringBuilder sb = new StringBuilder();
    List<List<String>> res = new LinkedList<>();
    char[][] board;
    int N;

    public List<List<String>> solveNQueens(int n) {
        N = n;
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.';
            }
        }
        backTracking(0);
        return res;
    }

    private void backTracking(int num) {
        if (num == N) {
            List<String> listBoard = new LinkedList<>();
            for (char[] row : board) {
                listBoard.add(String.valueOf(row));
            }
            res.add(listBoard);
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!isValid(num, j)) {
                continue;
            }
            board[num][j] = 'Q';
            backTracking(num + 1);
            board[num][j] = '.';
        }

    }

    boolean isValid(int r, int c) {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }

        for (int dx = 0; r - dx >= 0 && c - dx >= 0; dx++) {
            if (board[r - dx][c - dx] == 'Q') {
                return false;
            }
        }

        for (int dx = 0; r - dx >= 0 && c + dx < N; dx++) {
            if (board[r - dx][c + dx] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

