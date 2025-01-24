/*
 * @lc app=leetcode id=870 lang=java
 * @lcpr version=20004
 *
 * [870] Advantage Shuffle
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;

        PriorityQueue<int[]> maxPq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                });

        for (int i = 0; i < n; i++) {
            maxPq.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);

        int left = 0, right = n - 1;
        int[] res = new int[n];

        while (!maxPq.isEmpty()) {
            int[] pair = maxPq.poll();
            int i = pair[0], maxVal = pair[1];

            if (nums1[right] > maxVal) {
                res[i] = nums1[right];
                right--;
            } else {
                res[i] = nums1[left];
                left++;
            }

        }
        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [2,7,11,15]\n[1,10,4,11]\n
// @lcpr case=end

// @lcpr case=start
// [12,24,8,32]\n[13,25,32,11]\n
// @lcpr case=end

 */
