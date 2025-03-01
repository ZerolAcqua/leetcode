/*
 * @lc app=leetcode id=238 lang=java
 * @lcpr version=30005
 *
 * [238] Product of Array Except Self
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] prefix = new int [n  + 1];
        int [] suffix = new int [n + 1];
        prefix[0] = 1;
        suffix[n] = 1;

        for(int i = 1; i <= n ; i++) {
            prefix[i] = prefix[i-1 ] * nums[i-1];
        }

        for(int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i];
        }

        for(int i = 0 ; i< n ; i++) {
            nums[i] = prefix[i]*suffix[i+1];
        }

        return nums;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// [-1,1,0,-3,3]\n
// @lcpr case=end

 */

