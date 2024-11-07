/*
 * @lc app=leetcode id=52 lang=cpp
 * @lcpr version=20002
 *
 * [52] N-Queens II
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
    int totalNQueens(int n)
    {
        vector<string> board(n, string(n, '.'));
        backtrack(board, 0);
        return res;
    }

    void backtrack(vector<string> &board, int row)
    {
        if (row == board.size())
        {
            res++;
            return;
        }

        for (int col = 0; col < board.size(); col++)
        {
            if (!isValid(board, row, col))
                continue;
            board[row][col] = 'Q';
            row++;
            backtrack(board, row);
            row--;
            board[row][col] = '.';
        }
    }

    bool isValid(vector<string> &board, int row, int col)
    {
        for (int i = 1; row - i >= 0; i++)
        {
            if (board[row - i][col] == 'Q')
            {
                return false;
            }
        }

        for (int i = 1; row - i >= 0 && col - i >= 0; i++)
        {
            if (board[row - i][col - i] == 'Q')
            {
                return false;
            }
        }

        for (int i = 1; row - i >= 0 && col + i < board.size(); i++)
        {
            if (board[row - i][col + i] == 'Q')
            {
                return false;
            }
        }
        return true;
    }

private:
    int res = 0;
};

// @lc code=end

/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */
