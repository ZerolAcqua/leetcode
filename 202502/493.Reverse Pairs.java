/*
 * @lc app=leetcode id=493 lang=java
 * @lcpr version=20004
 *
 * [493] Reverse Pairs
 */

// @lcpr-template-start
// @lc code=start
class Solution {

    int[] tmp;
    int res;

    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        sortCount(nums, 0, nums.length - 1);
        return res;
    }

    void sortCount(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        sortCount(nums, low, mid);
        sortCount(nums, mid + 1, high);

        mergeCount(nums, low, mid, high);
    }

    void mergeCount(int[] nums, int low, int mid, int high) {

        for (int i = low; i <= high; i++) {
            tmp[i] = nums[i];
        }

        int end = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (end <= high && (long) nums[i] > (long) nums[end] * 2) {
                end++;
            }
            res += end - mid - 1;
        }

        int p1 = low, p2 = mid + 1;
        for (int i = low; i <= high; i++) {
            if (p1 > mid) {
                nums[i] = tmp[p2];
                p2++;
            } else if (p2 > high) {
                nums[i] = tmp[p1];
                p1++;
            } else if (tmp[p1] > tmp[p2]) {
                nums[i] = tmp[p2];
                p2++;
            } else {
                nums[i] = tmp[p1];
                p1++;
            }
        }
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,3,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [2,4,3,5,1]\n
// @lcpr case=end

 */
