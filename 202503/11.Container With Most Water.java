/*
 * @lc app=leetcode id=11 lang=java
 * @lcpr version=30005
 *
 * [11] Container With Most Water
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        int min = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                min = Math.max(min, height[left]);
                res = Math.max(res, min * (right - left));
                left++;
            } else {
                min = Math.max(min, height[right]);
                res = Math.max(res, min * (right - left));
                right--;
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,8,6,2,5,4,8,3,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,1]\n
// @lcpr case=end

 */

