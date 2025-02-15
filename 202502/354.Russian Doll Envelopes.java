/*
 * @lc app=leetcode id=354 lang=java
 * @lcpr version=30005
 *
 * [354] Russian Doll Envelopes
 */


// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,
                (int[] a, int[] b) -> {
                    return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
                });

        int[] tmp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            tmp[i] = envelopes[i][1];
        }
        return lengthOfLIS(tmp);
    }

    private int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int pile = 0;

        for (int num : nums) {
            int left = 0, right = pile - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (num <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            arr[left] = num;
            if (left == pile) {
                pile++;
            }

        }
        return pile;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[5,4],[6,4],[6,7],[2,3]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1],[1,1],[1,1]]\n
// @lcpr case=end

 */

