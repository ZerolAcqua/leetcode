/*
 * @lc app=leetcode id=1109 lang=java
 * @lcpr version=20004
 *
 * [1109] Corporate Flight Bookings
 */


// @lcpr-template-start
// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        Difference difference = new Difference(res);

        for (int[] booking : bookings) {
            difference.increase(booking[0] - 1, booking[1] - 1, booking[2]);
        }
        return difference.getResult();
    }

    class Difference {
        int[] diff;

        public Difference(int[] nums) {
            int n = nums.length;
            diff = new int[n];
            diff[0] = nums[0];
            for (int i = 1; i < n; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increase(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] getResult() {
            int n = diff.length;
            int[] res = new int[n];
            res[0] = diff[0];

            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] + diff[i];
            }

            return res;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,2,10],[2,3,20],[2,5,25]]\n5\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,10],[2,2,15]]\n2\n
// @lcpr case=end

 */

