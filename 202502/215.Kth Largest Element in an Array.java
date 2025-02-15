/*
 * @lc app=leetcode id=215 lang=java
 * @lcpr version=20004
 *
 * [215] Kth Largest Element in an Array
 */


// @lcpr-template-start
import java.util.Random;
// @lcpr-template-end
// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);

        int low = 0, high = nums.length - 1;
        k = nums.length - k;

        while (low <= high) {
            int mid = partition(nums, low, high);

            if (mid < k) {
                low = mid + 1;
            } else if (mid > k) {
                high = mid - 1;
            } else {
                return nums[mid];
            }

        }

        return -1;
    }

    int partition(int[] nums, int low, int high) {
        int pivot = nums[low];

        int i = low + 1, j = high;
        while (i <= j) {
            while (i < high && nums[i] <= pivot) {
                i++;
            }

            while (j > low && nums[j] > pivot) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
        }

        swap(nums, low, j);
        return j;
    }

    void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int r = rand.nextInt(n - i) + i;
            swap(nums, i, r);
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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

