/*
 * @lc app=leetcode id=15 lang=java
 * @lcpr version=30103
 *
 * [15] 3Sum
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> twoRes = twoSum(nums, i + 1, -nums[i]);
            if (!twoRes.isEmpty()) {
                for (List<Integer> list : twoRes) {
                    list.add(nums[i]);
                    res.add(list);
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] < target) {
                while (left + 1 < nums.length && nums[left + 1] == nums[left]) {
                    left++;
                }
                left++;

            } else if (nums[left] + nums[right] > target) {
                while (right - 1 >= 0 && nums[right - 1] == nums[right]) {
                    right--;
                }
                right--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(list);
                while (left + 1 < nums.length && nums[left + 1] == nums[left]) {
                    left++;
                }
                left++;
                while (right - 1 >= 0 && nums[right - 1] == nums[right]) {
                    right--;
                }
                right--;
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

