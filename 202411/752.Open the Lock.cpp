/*
 * @lc app=leetcode id=752 lang=cpp
 * @lcpr version=20002
 *
 * [752] Open the Lock
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
    int openLock(vector<string> &deadends, string target)
    {

        // 1. normal BFS
        {
            // unordered_set<string> deads(deadends.begin(), deadends.end());
            // unordered_set<string> visited;
            // queue<string> q;
            // int step = 0;

            // q.push("0000");

            // while (!q.empty())
            // {
            //     auto sz = q.size();

            //     for (int i = 0; i < sz; i++)
            //     {
            //         auto code = q.front();
            //         q.pop();

            //         if (code == target)
            //             return step;
            //         if (visited.count(code))
            //             continue;
            //         if (deads.count(code))
            //             continue;
            //         visited.insert(code);

            //         for (int j = 0; j < 4; j++)
            //         {
            //             q.push(addOne(code, j));
            //             q.push(minusOne(code, j));
            //         }
            //     }
            //     step++;
            // }
            // return -1;
        }
        // 2. bi-directional BFS
        {
            unordered_set<string> visited(deadends.begin(), deadends.end());

            unordered_set<string> q1, q2;

            int step = 0;

            q1.insert("0000");
            q2.insert(target);

            while (!q1.empty() && !q2.empty())
            {
                unordered_set<string> temp;

                for (const auto &code : q1)
                {
                    if (visited.count(code))
                        continue;
                    if (q2.count(code))
                        return step;

                    visited.insert(code);

                    for (int j = 0; j < 4; j++)
                    {
                        temp.insert(addOne(code, j));
                        temp.insert(minusOne(code, j));
                    }
                }
                q1 = move(temp);
                swap(q1, q2);
                step++;
            }
            return -1;
        }
    }

private:
    string addOne(string str, int i)
    {
        auto newStr = str;
        if (newStr[i] == '9')
        {
            newStr[i] = '0';
        }
        else
        {
            newStr[i]++;
        }

        return newStr;
    }

    string minusOne(string str, int i)
    {
        auto newStr = str;
        if (newStr[i] == '0')
        {
            newStr[i] = '9';
        }
        else
        {
            newStr[i]--;
        }

        return newStr;
    }
};
// @lc code=end

/*
// @lcpr case=start
// ["0201","0101","0102","1212","2002"]\n"0202"\n
// @lcpr case=end

// @lcpr case=start
// ["8888"]\n"0009"\n
// @lcpr case=end

// @lcpr case=start
// ["8887","8889","8878","8898","8788","8988","7888","9888"]\n"8888"\n
// @lcpr case=end

 */
