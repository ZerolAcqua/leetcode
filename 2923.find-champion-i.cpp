/*
 * @lc app=leetcode id=2923 lang=cpp
 *
 * [2923] Find Champion I
 */

#include <iostream>
#include <string>
#include <vector>
#include <numeric>

using namespace std;

// @lc code=start
class Solution
{
public:
    int findChampion(vector<vector<int>> &grid)
    {
        int n = grid.size();
        for (int i = 0; i < n; i++)
        {
            int sum = std::accumulate(grid[i].begin(), grid[i].end(), 0);
            if (sum == n - 1)
            {
                return i;
            }
        }

        return -1;
    }
};
// @lc code=end

int main()
{
}
