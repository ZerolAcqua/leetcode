/*
 * @lc app=leetcode id=39 lang=java
 * @lcpr version=20003
 *
 * [39] Combination Sum
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target);
        return res;
    }

    void backtrack(int[] candidates, int start, int target) {
        // base case
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target)
            return;

        for (int i = start; i < candidates.length; i++) {
            trackSum += candidates[i];
            track.addLast(candidates[i]);
            backtrack(candidates, i, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,6,7]\n7\n
// @lcpr case=end

// @lcpr case=start
// [2,3,5]\n8\n
// @lcpr case=end

// @lcpr case=start
// [2]\n1\n
// @lcpr case=end

 */

