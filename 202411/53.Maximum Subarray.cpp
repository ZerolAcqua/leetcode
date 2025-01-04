/*
 * @lc app=leetcode id=53 lang=cpp
 * @lcpr version=20001
 *
 * [53] Maximum Subarray
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
    int maxSubArray(vector<int> &nums)
    {
        //--- sliding window ---
        // {
        //     int right = 0, left = 0;
        //     int res = INT_MIN;

        //     int sum = 0;

        //     while (right < nums.size())
        //     {
        //         sum += nums[right];
        //         res = max(res, sum);
        //         right++;

        //         while (left < right && sum < 0)
        //         {
        //             sum -= nums[left];
        //             left++;
        //         }
        //     }
        //     return res;
        // }

        //--- prefix sum ---
        // {
        //     int n = nums.size();
        //     vector<int> preSum(n + 1, 0);

        //     for (int i = 1; i < preSum.size(); i++)
        //     {
        //         preSum[i] = preSum[i - 1] + nums[i - 1];
        //     }

        //     int res = INT_MIN;
        //     int minPreSum = 0;

        //     for (int i = 1; i < preSum.size(); i++)
        //     {
        //         res = max(res, preSum[i] - minPreSum);
        //         minPreSum = min(minPreSum, preSum[i]);
        //     }

        //     return res;
        // }

        //--- dynamic programming ---
        {
            int n = nums.size();
            int dpLast = nums[0];
            int res = dpLast;

            for (int i = 1; i < n; i++)
            {
                dpLast = max(nums[i], dpLast + nums[i]);
                res = max(res, dpLast);
            }

            return res;
        }

        //--- divide and conquer ---
        // TODO:
    }
};
// @lc code=end

/*
// @lcpr case=start
// [-2,1,-3,4,-1,2,1,-5,4]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// [5,4,-1,7,8]\n
// @lcpr case=end

 */
