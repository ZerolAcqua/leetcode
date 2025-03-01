/*
 * @lc app=leetcode id=42 lang=java
 * @lcpr version=30005
 *
 * [42] Trapping Rain Water
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int min = 0;
        int res = 0;

        while (left < right) {

            int vol = 0;
            if (height[left] < height[right]) {
                min = Math.max(min, height[left]);
                vol = Math.max(0, min - height[left]);
                left++;
            } else {
                min = Math.max(min, height[right]);
                vol = Math.max(0, min - height[right]);
                right--;
            }

            res += vol;
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,0,2,1,0,1,3,2,1,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [4,2,0,3,2,5]\n
// @lcpr case=end

 */

