/*
 * @lc app=leetcode id=496 lang=java
 * @lcpr version=30005
 *
 * [496] Next Greater Element I
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        int[] larger = new int[nums2.length];

        for (int i = 0; i < nums2.length; i++) {
            hs.put(nums2[i], i);
        }

        Stack<Integer> stk = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stk.isEmpty()) {
                int top = stk.peek();
                if (top <= num) {
                    stk.pop();
                } else {
                    break;
                }
            }

            if (stk.isEmpty()) {
                larger[i] = -1;
            } else {
                larger[i] = stk.peek();
            }

            stk.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = larger[hs.get(nums1[i])];
        }

        return nums1;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [4,1,2]\n[1,3,4,2]\n
// @lcpr case=end

// @lcpr case=start
// [2,4]\n[1,2,3,4]\n
// @lcpr case=end

 */
