/*
 * @lc app=leetcode id=1 lang=java
 * @lcpr version=30103
 *
 * [1] Two Sum
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        Arrays.sort(pairs, (p1, p2) -> p1.val - p2.val);
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = pairs[left].val + pairs[right].val;
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{pairs[left].idx, pairs[right].idx};
            }
        }
        return new int[0];
    }
}

class Pair {

    int val;
    int idx;

    public Pair() {
    }

    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [2,7,11,15]\n9\n
// @lcpr case=end

// @lcpr case=start
// [3,2,4]\n6\n
// @lcpr case=end

// @lcpr case=start
// [3,3]\n6\n
// @lcpr case=end

 */
