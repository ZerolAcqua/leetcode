/*
 * @lc app=leetcode id=219 lang=java
 * @lcpr version=20004
 *
 * [219] Contains Duplicate II
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int n = nums.length;
        int left = 0, right = 0;
        HashSet<Integer> window = new HashSet<>();

        while (right < n) {
            if (window.contains(nums[right])) {
                return true;
            }

            window.add(nums[right]);
            right++;

            if (right - left > k) {
                window.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,3,1]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1,0,1,1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,1,2,3]\n2\n
// @lcpr case=end

 */
