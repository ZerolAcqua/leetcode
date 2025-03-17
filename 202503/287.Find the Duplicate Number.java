/*
 * @lc app=leetcode id=287 lang=java
 * @lcpr version=30005
 *
 * [287] Find the Duplicate Number
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0; 
        int fast = 0;

        while(true) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            if(slow == fast) {
                break;
            }
        }

        slow = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[fast];
            if(slow == fast) {
                break;
            }
        }

        return slow;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,4,2,2]\n
// @lcpr case=end

// @lcpr case=start
// [3,1,3,4,2]\n
// @lcpr case=end

// @lcpr case=start
// [3,3,3,3,3]\n
// @lcpr case=end

 */

