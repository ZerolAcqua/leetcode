/*
 * @lc app=leetcode id=118 lang=java
 * @lcpr version=30005
 *
 * [118] Pascal's Triangle
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);

            if (i == 0) {
                res.add(row);
                continue;
            }

            if (i > 1) {

                List<Integer> lastRow = res.get(i - 1);
                for (int j = 1; j < i; j++) {
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            row.add(1);
            res.add(row);
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// 5\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */
