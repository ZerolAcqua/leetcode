/*
 * @lc app=leetcode id=220 lang=java
 * @lcpr version=20004
 *
 * [220] Contains Duplicate III
 */

// @lcpr-template-start
import java.util.TreeSet;
// @lcpr-template-end
// @lc code=start

class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        int left = 0, right = 0;

        TreeSet<Integer> window = new TreeSet<>();

        while (right < n) {
            if (right - left <= indexDiff) {
                if (right != left) {
                    Integer ceiling = window.ceiling(nums[right]);
                    if (ceiling != null && ceiling - nums[right] <= valueDiff) {
                        return true;
                    }
                    Integer floor = window.floor(nums[right]);
                    if (floor != null && nums[right] - floor <= valueDiff) {
                        return true;
                    }

                }

                window.add(nums[right]);
                right++;
            } else {
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
// [1,2,3,1]\n3\n0\n
// @lcpr case=end

// @lcpr case=start
// [1,5,9,1,5,9]\n2\n3\n
// @lcpr case=end

 */
