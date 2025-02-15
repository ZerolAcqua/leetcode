/*
 * @lc app=leetcode id=315 lang=java
 * @lcpr version=20004
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {

    private class Pair {

        int val, id;

        Pair(int val, int id) {
            this.val = val;
            this.id = id;
        }
    }

    private Pair[] tmp;
    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        tmp = new Pair[nums.length];
        Pair[] arr = new Pair[nums.length];
        count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        sort(arr, 0, nums.length - 1);

        List<Integer> res = new LinkedList<>();

        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    void sort(Pair[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        sort(nums, low, mid);
        sort(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    void merge(Pair[] nums, int low, int mid, int high) {

        for (int i = low; i <= high; i++) {
            tmp[i] = nums[i];
        }

        int p1 = low;
        int p2 = mid + 1;

        for (int i = low; i <= high; i++) {
            if (p1 > mid) {
                nums[i] = tmp[p2];
                p2++;
            } else if (p2 > high) {
                nums[i] = tmp[p1];
                count[nums[i].id] += high - mid;
                p1++;
            } else if (tmp[p1].val <= tmp[p2].val) {
                nums[i] = tmp[p1];
                count[nums[i].id] += p2 - mid - 1;
                p1++;
            } else {
                nums[i] = tmp[p2];
                p2++;
            }
        }
    }
}
// @lc code=end

/*
// @lcpr case=start
// [5,2,6,1]\n
// @lcpr case=end

// @lcpr case=start
// [-1]\n
// @lcpr case=end

// @lcpr case=start
// [-1,-1]\n
// @lcpr case=end

 */
