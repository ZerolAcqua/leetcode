/*
 * @lc app=leetcode id=503 lang=java
 * @lcpr version=30005
 *
 * [503] Next Greater Element II
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        Stack<Integer> stk = new Stack<>();
        int[] res = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= nums[i % n]) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                res[i % n] = -1;
            } else {
                res[i % n] = stk.peek();
            }
            stk.push(nums[i % n]);
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,3]\n
// @lcpr case=end

 */
