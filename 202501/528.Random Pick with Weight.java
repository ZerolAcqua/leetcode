/*
 * @lc app=leetcode id=528 lang=java
 * @lcpr version=20004
 *
 * [528] Random Pick with Weight
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {

    private int[] preSum;

    private Random rand = new Random(); 

    public Solution(int[] w) {
        preSum = new int[w.length + 1];

        for ( int i = 1 ; i <= w.length ; i ++) {
            preSum[i] = preSum[i-1] + w[i-1];
        }
    }

    public int pickIndex() {
        int n = preSum.length;
        int target = rand.nextInt(1,preSum[n-1]+1);

        int index = leftBound(preSum, target);
        return index - 1;
    


    }

    private int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1 ;

        while(left <= right) {
            int mid = left + (right -  left) /2;

            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end



