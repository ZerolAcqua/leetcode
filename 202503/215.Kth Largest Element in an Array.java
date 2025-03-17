/*
 * @lc app=leetcode id=215 lang=java
 * @lcpr version=30103
 *
 * [215] Kth Largest Element in an Array
 */

import java.util.Random;

// @lc code=start
class Solution {

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                return nums[p];
            }
        }

        return -1;

    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];

        int i = lo + 1, j = hi;
        while (i <= j) {
            while (i < hi && nums[i] < pivot) {
                i++;
            }
            while (j > lo && nums[j] > pivot) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
            i++;
            j--;
        }

        swap(nums, lo, j);
        return j;
    }

    private void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [3,2,1,5,6,4]\n2\n
// @lcpr case=end

// @lcpr case=start
// [3,2,3,1,2,4,5,5,6]\n4\n
// @lcpr case=end

 */
