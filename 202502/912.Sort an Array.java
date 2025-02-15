/*
 * @lc app=leetcode id=912 lang=java
 * @lcpr version=20004
 *
 * [912] Sort an Array
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start

import java.util.Random;

class Solution {

    public int[] sortArray(int[] nums) {
        MergeSort.sort(nums);
        return nums;
    }

}

class MergeSort {

    private static int[] temp;

    public static int[] sort(int[] nums) {
        temp = new int[nums.length];
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private static void sortArray(int[] nums, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        sortArray(nums, low, mid);
        sortArray(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {

        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }

        int p1 = low;
        int p2 = mid + 1;

        for (int i = low; i <= high; i++) {
            if (p1 > mid) {
                nums[i] = temp[p2];
                p2++;
            } else if (p2 > high) {
                nums[i] = temp[p1];
                p1++;
            } else if (temp[p1] < temp[p2]) {
                nums[i] = temp[p1];
                p1++;
            } else {
                nums[i] = temp[p2];
                p2++;
            }
        }
    }
}

class QuickSort {

    public static int[] sort(int[] nums) {
        shuffle(nums);
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private static void sortArray(int[] nums, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = partition(nums, low, high);

        sortArray(nums, low, mid - 1);
        sortArray(nums, mid + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
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

    private static void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int r = rand.nextInt(n - i) + i;
            swap(nums, i, r);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [5,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [5,1,1,2,0,0]\n
// @lcpr case=end

 */
