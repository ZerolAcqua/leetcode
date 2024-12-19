/*
 * @lc app=leetcode id=80 lang=java
 * @lcpr version=20004
 *
 * [80] Remove Duplicates from Sorted Array II
 */


// @lcpr-template-start
// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;
        int count = 0;
        int currNum = nums[0];

        while (fast < nums.length) {
            if (nums[fast] == currNum) {
                count++;
                fast++;
                if (count <= 2) {
                    nums[slow] = currNum;
                    slow++;
                }
            }
            else{
                count = 0;
                currNum = nums[fast];
            }
        }

        return slow;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,1,2,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,1,1,1,1,2,3,3]\n
// @lcpr case=end

 */

