/*
 * @lc app=leetcode id=1329 lang=java
 * @lcpr version=20004
 *
 * [1329] Sort the Matrix Diagonally
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        HashMap<Integer, ArrayList<Integer>> diagonals = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i - j;
                diagonals.putIfAbsent(id, new ArrayList<>());
                diagonals.get(id).add(mat[i][j]);
            }
        }

        for (List<Integer> diagonal : diagonals.values()) {
            Collections.sort(diagonal, Collections.reverseOrder());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> diagonal = diagonals.get(i - j);
                mat[i][j] = diagonal.remove(diagonal.size() - 1);
            }
        }

        return mat;

    }
}
// @lc code=end

/*
// @lcpr case=start
// [[3,3,1,1],[2,2,1,2],[1,1,1,2]]\n
// @lcpr case=end

// @lcpr case=start
// [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]\n
// @lcpr case=end

 */
