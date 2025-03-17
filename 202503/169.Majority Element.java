/*
 * @lc app=leetcode id=169 lang=java
 * @lcpr version=30005
 *
 * [169] Majority Element
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = Integer.MIN_VALUE;

        for(int i : nums) {
            if(count == 0) {
                count ++;
                num = i;
            }  else {
                if(i == num) {
                    count ++;
                } else {
                    count --;
                }
            }
        }

        return num;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [2,2,1,1,1,2,2]\n
// @lcpr case=end

 */

