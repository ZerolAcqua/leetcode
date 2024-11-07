/*
 * @lc app=leetcode id=322 lang=cpp
 * @lcpr version=20002
 *
 * [322] Coin Change
 */

// @lcpr-template-start
using namespace std;
#include <algorithm>
#include <array>
#include <bitset>
#include <climits>
#include <deque>
#include <functional>
#include <iostream>
#include <list>
#include <queue>
#include <stack>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>
// @lcpr-template-end
// @lc code=start
class Solution
{
public:
    int coinChange(vector<int> &coins, int amount)
    {
        vector<int> dp(amount + 1, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.size(); i++)
        {
            for (auto coin : coins)
            {
                if (i - coin < 0)
                    continue;
                dp[i] = min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[amount] > amount)
        {
            return -1;
        }
        else
        {
            return dp[amount];
        }
    }
};
// @lc code=end

/*
// @lcpr case=start
// [1,2,5]\n11\n
// @lcpr case=end

// @lcpr case=start
// [2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

 */
