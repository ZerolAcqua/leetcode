/*
 * @lc app=leetcode id=56 lang=java
 * @lcpr version=30005
 *
 * [56] Merge Intervals
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        LinkedList<int[]> tmp = new LinkedList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int newLeft = intervals[i][0];
            int newRight = intervals[i][1];

            if (newLeft <= right) {
                right = Math.max(right, newRight);
            } else {
                tmp.add(new int[]{left, right});
                left = newLeft;
                right = newRight;
            }
        }

        tmp.add(new int[]{left, right});

        return tmp.toArray(new int[0][0]);
    }
}
// @lc code=end

/*
// @lcpr case=start
// [[1,3],[2,6],[8,10],[15,18]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,4],[4,5]]\n
// @lcpr case=end

 */
