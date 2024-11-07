/*
 * @lc app=leetcode id=51 lang=cpp
 * @lcpr version=20002
 *
 * [51] N-Queens
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
    vector<vector<string>> solveNQueens(int n)
    {
        vector<string> board(n, string(n, '.'));
        backtrack(board, 0);
        return res;
    }

    void backtrack(vector<string> &board, int row)
    {
        // printIndent(count++);
        // cout << "[enter] " << row << endl;
        if (row == board.size())
        {
            res.push_back(board);

            // printIndent(count--);
            // cout << "[return] " << endl;
            return;
        }
        // printIndent(count);
        // cout << "[choose]" << endl;

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
        // printIndent(count--);
        // cout << "[return] " << endl;
    }

    bool isValid(vector<string> &board, int row, int col)
    {
        // printIndent(count);
        // cout << "[isValid]---" << endl;
        for (int i = 1; row - i >= 0; i++)
        {
            // printIndent(count);
            // cout << "[isValid] up"
            //      << " " << row - i << " " << col << endl;
            if (board[row - i][col] == 'Q')
            {
                // printIndent(count);
                // cout << "[isValid]---fail" << endl;
                return false;
            }
        }

        for (int i = 1; row - i >= 0 && col - i >= 0; i++)
        {
            // printIndent(count);
            // cout << "[isValid] rightup"
            //      << " " << row - i << " " << col - i << endl;
            if (board[row - i][col - i] == 'Q')
            {
                // printIndent(count);
                // cout << "[isValid]---fail" << endl;
                return false;
            }
        }

        for (int i = 1; row - i >= 0 && col + i < board.size(); i++)
        {
            // printIndent(count);
            // cout << "[isValid] leftup"
            //      << " " << row - i << " " << col + i << endl;
            if (board[row - i][col + i] == 'Q')
            {
                // printIndent(count);
                // cout << "[isValid]---fail" << endl;
                return false;
            }
        }
        // printIndent(count);
        // cout << "[isValid]---pass" << endl;
        return true;
    }

    // 输入 n，打印 n 个 tab 缩进
    // void printIndent(int n) {
    //     for (int i = 0; i < n; i++) {
    //         cout << "  ";
    //     }
    // }

private:
    vector<vector<string>> res;
    // int count = 0;
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
