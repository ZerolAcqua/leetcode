/*
 * @lc app=leetcode id=121 lang=java
 * @lcpr version=30005
 *
 * [121] Best Time to Buy and Sell Stock
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;

        for(int price : prices) {
            if(price< min) {
                min = price;
            } else {
                res = Math.max(res, price - min);
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [7,1,5,3,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [7,6,4,3,1]\n
// @lcpr case=end

 */

