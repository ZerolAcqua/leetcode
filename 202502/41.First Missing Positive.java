/*
 * @lc app=leetcode id=41 lang=java
 * @lcpr version=30005
 *
 * [41] First Missing Positive
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean hasOne = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                hasOne = true;
            }

            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        if (!hasOne) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i]>0){
                return i+1;
            }
        }

        return n + 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,0]\n
// @lcpr case=end

// @lcpr case=start
// [3,4,-1,1]\n
// @lcpr case=end

// @lcpr case=start
// [7,8,9,11,12]\n
// @lcpr case=end

 */

