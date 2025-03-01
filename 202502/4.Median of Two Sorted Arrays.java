/*
 * @lc app=leetcode id=4 lang=java
 * @lcpr version=30005
 *
 * [4] Median of Two Sorted Arrays
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;

        if (total % 2 == 1) {
            return findMedianInRange(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);
        } else {
            return (findMedianInRange(nums1, 0, m - 1, nums2, 0, n - 1, total / 2)
                    + findMedianInRange(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1)) / 2.0;
        }
    }

    int findMedianInRange(int[] nums1, int l1, int h1, int[] nums2, int l2, int h2, int k) {
        if (l1 > h1) {
            return nums2[l2 + k - 1];
        }

        if (l2 > h2) {
            return nums1[l1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }

        int offset = k / 2;

        int mid1 = Math.min(l1 + offset - 1, h1);
        int mid2 = Math.min(l2 + offset - 1, h2);

        if (nums1[mid1] <= nums2[mid2]) {
            return findMedianInRange(nums1, mid1 + 1, h1, nums2, l2, h2, k - (mid1 - l1 + 1));
        } else {
            return findMedianInRange(nums1, l1, h1, nums2, mid2 + 1, h2, k - (mid2 - l2 + 1));
        }

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3]\n[2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n[3,4]\n
// @lcpr case=end

 */


