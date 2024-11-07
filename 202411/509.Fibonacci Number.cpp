/*
 * @lc app=leetcode id=509 lang=cpp
 * @lcpr version=20002
 *
 * [509] Fibonacci Number
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
    int fib(int n)
    {
        if (n < 2)
            return n;
        int dp0 = 0;
        int dp1 = 1;
        for (int i = 2; i <= n; i++)
        {
            int dpi = dp0 + dp1;
            dp0 = dp1;
            dp1 = dpi;
        }
        return dp1;
    }
}
;
// @lc code=end

/*
// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 4\n
// @lcpr case=end

 */
