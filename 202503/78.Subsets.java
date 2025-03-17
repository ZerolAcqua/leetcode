/*
 * @lc app=leetcode id=78 lang=java
 * @lcpr version=30103
 *
 * [78] Subsets
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    private void backTracking(int[] nums, int idx) {

        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        backTracking(nums, idx + 1);

        path.add(nums[idx]);
        backTracking(nums, idx + 1);
        path.removeLast();
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */
