/*
 * @lc app=leetcode id=84 lang=java
 * @lcpr version=30103
 *
 * [84] Largest Rectangle in Histogram
 */

import java.util.Deque;
import java.util.ArrayDeque;

// @lc code=start
class Solution {

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stk = new ArrayDeque<Integer>();
        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && heights[i] <= heights[stk.peek()]) {
                int idx = stk.pop();
                right[idx] = i;
            }

            if (stk.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stk.peek();
            }
            stk.push(i);
        }

        while (!stk.isEmpty()) {
            int idx = stk.pop();
            right[idx] = n;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [2,1,5,6,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [2,4]\n
// @lcpr case=end

 */
