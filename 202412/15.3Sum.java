/*
 * @lc app=leetcode id=15 lang=java
 * @lcpr version=20004
 *
 * [15] 3Sum
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int target = nums[i];
            List<List<Integer>> tuples = twoSum(nums, i + 1, -target);

            for (List<Integer> tuple : tuples) {
                tuple.add(target);
                res.add(tuple);
            }

            while (i + 1 < n && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return res;
    }

    List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();

        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = lo;
            int right = hi;

            if (sum < target) {
                while (lo < hi && nums[lo] == nums[left]) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == nums[right]) {
                    hi--;
                }
            } else {
                res.add(new ArrayList<>(Arrays.asList(nums[lo], nums[hi])));
                while (lo < hi && nums[lo] == nums[left]) {
                    lo++;
                }
                while (lo < hi && nums[hi] == nums[right]) {
                    hi--;
                }
            }
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [-1,0,1,2,-1,-4]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,1]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,0]\n
// @lcpr case=end

 */
