/*
 * @lc app=leetcode id=658 lang=java
 * @lcpr version=20004
 *
 * [658] Find K Closest Elements
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();

        int center = getLeftBound(arr, x);
        int left = center - 1, right = center;
        System.out.println(center);

        while (right - left - 1 < k) {
            if (left < 0) {
                res.addLast(arr[right]);
                right++;
            } else if (right >= arr.length) {
                res.addFirst(arr[left]);
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                res.addFirst(arr[left]);
                left--;
            } else {
                res.addLast(arr[right]);
                right++;
            }
        }

        return res;

    }

    int getLeftBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,3,4,5]\n4\n3\n
// @lcpr case=end

// @lcpr case=start
// [1,1,2,3,4,5]\n4\n-1\n
// @lcpr case=end

 */
