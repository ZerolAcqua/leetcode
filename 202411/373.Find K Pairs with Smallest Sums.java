/*
 * @lc app=leetcode id=373 lang=java
 * @lcpr version=20003
 *
 * [373] Find K Pairs with Smallest Sums
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // {nums1[i],nums2[i],i}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    return a[0] + a[1] - b[0] - b[1];
                });

        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();

        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            int num1 = cur[0];
            int num2 = cur[1];
            int j = cur[2];
            List<Integer> pair = new ArrayList<>();
            pair.add(num1);
            pair.add(num2);
            res.add(pair);
            k--;

            if (j + 1 < nums2.length) {
                pq.offer(new int[]{num1, nums2[j + 1], j + 1});
            }
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,7,11]\n[2,4,6]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1,1,2]\n[1,2,3]\n2\n
// @lcpr case=end

 */
