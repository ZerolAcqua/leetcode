/*
 * @lc app=leetcode id=45 lang=java
 * @lcpr version=30005
 *
 * [45] Jump Game II
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int farest = 0;
        int end = 0;
        int jump = 0;

        for (int i = 0; i < nums.length -1; i++) {
            farest = Math.max(nums[i] + i, farest);

            if (i == end) {
                end = farest;
                jump++;
            }
        }

        return jump;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,1,1,4]\n
// @lcpr case=end

// @lcpr case=start
// [2,3,0,1,4]\n
// @lcpr case=end

 */

