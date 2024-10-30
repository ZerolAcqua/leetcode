/*
 * @lc app=leetcode id=209 lang=cpp
 * @lcpr version=20001
 *
 * [209] Minimum Size Subarray Sum
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
    int minSubArrayLen(int target, vector<int> &nums)
    {
        // prefix sum
        int n = nums.size();
        vector<int> preSum(n + 1, 0);

        for (int i = 1; i < preSum.size(); i++)
        {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        //--- 1. sliding window ---
        {
            int res = INT_MAX;
            int left, right = 0;

            while (right < preSum.size())
            {
                right++;
                while (right < preSum.size() && preSum[right] - preSum[left] >= target)
                {
                    res = min(res, right - left);
                    left++;
                }
            }
            return res == INT_MAX ? 0 : res;
        }

        //--- 2. binary search ---
        // TODO:
    }
};
// @lc code=end

/*
// @lcpr case=start
// 7\n[2,3,1,2,4,3]\n
// @lcpr case=end

// @lcpr case=start
// 4\n[1,4,4]\n
// @lcpr case=end

// @lcpr case=start
// 11\n[1,1,1,1,1,1,1,1]\n
// @lcpr case=end

 */
