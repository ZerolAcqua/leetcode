/*
 * @lc app=leetcode id=1222 lang=cpp
 *
 * [1222] Queens That Can Attack the King
 */

#include <iostream>
#include <string>
#include <vector>

using namespace std;

// @lc code=start
class Solution
{
public:
  vector<vector<int>> queensAttacktheKing(vector<vector<int>> &queens,
                                          vector<int> &king)
  {
    vector<vector<int>> res;

    // 位运算打表皇后位置
    long long int queenMap = 0;
    for (auto queen : queens)
    {
      queenMap |= 1LL << (queen[0] * 8 + queen[1]);
    }

    // 从国王往八个方向搜索
    auto dirs = vector<pair<int, int>>{
        {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    for (auto &&[rowOff, colOff] : dirs)
    {
      int row = king[0], col = king[1];
      while (row >= 0 && row < 8 && col >= 0 && col < 8)
      {
        if (queenMap & (1LL << (row * 8 + col)))
        {
          res.push_back({row, col});
          break;
        }
        row += rowOff;
        col += colOff;
      }
    }

    return res;
  }
};
// @lc code=end

int main()
{
  auto queens = vector<vector<int>>{{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}};
  auto king = vector<int>{3, 3};
  Solution sol;
  auto res = sol.queensAttacktheKing(queens, king);
  for (auto &v : res)
  {
    for (auto &i : v)
    {
      cout << i << " ";
    }
    cout << endl;
  }
}