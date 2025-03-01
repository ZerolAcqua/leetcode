/*
 * @lc app=leetcode id=31 lang=java
 * @lcpr version=30005
 *
 * [31] Next Permutation
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return;

        int p1 = n - 1;
        while (p1 >= 1) {
            if (nums[p1] > nums[p1 - 1]) {
                break;
            }
            p1--;
        }

        if (p1 == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int p2 = n - 1;
        while (p2 >= p1) {
            if (nums[p2] > nums[p1 - 1]) {
                break;
            }
            p2--;
        }
        swap(nums, p1 - 1, p2);
        reverse(nums, p1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        int temp;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,5]\n
// @lcpr case=end

 */

