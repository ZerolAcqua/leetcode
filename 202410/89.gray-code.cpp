/*
 * @lc app=leetcode id=89 lang=cpp
 * @lcpr version=20000
 *
 * [89] Gray Code
 */

#include <bits/stdc++.h>
#include <iostream>
#include <vector>
using namespace std;

// @lc code=start
class Solution
{
public:
    vector<int> grayCode(int n)
    {
        auto res = vector<int>(1 << n);
        iota(res.begin(), res.end(), 0);
        auto func = [](int x)
        { return x ^ (x >> 1); };
        transform(res.begin(), res.end(), res.begin(), func);
        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */
