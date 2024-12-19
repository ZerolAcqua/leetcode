/*
 * @lc app=leetcode id=75 lang=java
 * @lcpr version=20004
 *
 * [75] Sort Colors
 */

// @lcpr-template-start
// @lc code=start

class Solution {

    public void sortColors(int[] nums) {

        int head = 0;
        int tail = nums.length - 1;
        int p = 0;

        while (p <= tail) {
            if (nums[p] == 0) {
                swap(nums, p, head);
                head++;
            } else if (nums[p] == 2) {
                swap(nums, p, tail);
                tail--;
            } else {
                p++;
            }

            if (p < head) {
                p = head;
            }
        }

    }

    void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
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
