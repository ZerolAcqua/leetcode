/*
 * @lc app=leetcode id=75 lang=java
 * @lcpr version=30100
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int p = 0;

        while (p <= right) {
            while (left < n &&nums[left] == 0) {
                left++;
            }

            if (p < left) {
                p = left;
            }

            while(right >= 0 && nums[right]==2) {
                right--;
            }

            if(p > right) {
                break;
            }

            if (nums[p] == 2) {
                swap(nums, p , right);
                right--;
            }

            if (nums[p] == 0) {
                swap(nums, p , left);
                left++;
            }

            p++;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,0,2,1,1,0]\n
// @lcpr case=end

// @lcpr case=start
// [2,0,1]\n
// @lcpr case=end

 */

