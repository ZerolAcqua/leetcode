/*
 * @lc app=leetcode id=327 lang=java
 * @lcpr version=20004
 *
 * [327] Count of Range Sum
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    int lower, upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] preSum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        this.lower = lower;
        this.upper = upper;
        return countDiff(preSum);
    }

    int count;
    long[] tmp;

    int countDiff(long[] nums) {
        tmp = new long[nums.length];
        sortCount(nums, 0, nums.length - 1);
        return count;
    }

    void sortCount(long[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        sortCount(nums, low, mid);
        sortCount(nums, mid + 1, high);
        mergeCount(nums, low, mid, high);
    }

    void mergeCount(long[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tmp[i] = nums[i];
        }

        int start = mid + 1;
        int end = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (start <= high && nums[start] - nums[i] < lower) {
                start++;
            }

            while (end <= high && nums[end] - nums[i] <= upper) {
                end++;
            }

            count += end - start;
        }

        int p1 = low, p2 = mid + 1;
        for (int i = low; i <= high; i++) {
            if (p1 > mid) {
                nums[i] = tmp[p2++];
            } else if (p2 > high) {
                nums[i] = tmp[p1++];
            } else if (tmp[p1] < tmp[p2]) {
                nums[i] = tmp[p1++];
            } else {
                nums[i] = tmp[p2++];
            }
        }
    }
}
// @lc code=end

/*
// @lcpr case=start
// [-2,5,-1]\n-2\n2\n
// @lcpr case=end

// @lcpr case=start
// [0]\n0\n0\n
// @lcpr case=end

 */
