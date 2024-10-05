/*
 * @lc app=leetcode id=2312 lang=cpp
 *
 * [2312] Selling Pieces of Wood
 */

#include <vector>
#include <iostream>

using namespace std;

// @lc code=start
class Solution
{
public:
    long long sellingWood(int m, int n, vector<vector<int>> &prices)
    {

        auto dp = vector<vector<long long>>(m + 1, vector<long long>(n + 1, 0));

        // initialize the dp array
        for (auto &&price : prices)
        {
            if (price[0] > m || price[1] > n)
            {
                continue;
            }
            dp[price[0]][price[1]] = price[2];
        }

        // state transition
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // vertical cut
                for (int k = 1; k <= j / 2; k++)
                {
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[i][j - k]);
                }

                // horizontal cut
                for (int k = 1; k <= i / 2; k++)
                {
                    dp[i][j] = max(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
            }
        }

        return dp[m][n];
    }
};
// @lc code=end

int main()
{
    Solution sol;
    vector<vector<int>> prices = {{1, 4, 2}, {2, 2, 7}, {2, 1, 3}};
    int m = 3;
    int n = 5;
    long long ans = sol.sellingWood(m, n, prices);
    cout << ans << endl;
    return 0;
}