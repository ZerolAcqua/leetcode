/*
 * @lc app=leetcode id=739 lang=java
 * @lcpr version=30005
 *
 * [739] Daily Temperatures
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] res = new int[n];

        Deque<Integer> stk = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && temperatures[i] >= temperatures[stk.peek()]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                res[i] = stk.peek() - i;
            } else {
                res[i] = 0;
            }
            stk.push(i);
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [73,74,75,71,69,72,76,73]\n
// @lcpr case=end

// @lcpr case=start
// [30,40,50,60]\n
// @lcpr case=end

// @lcpr case=start
// [30,60,90]\n
// @lcpr case=end

 */
