/*
 * @lc app=leetcode id=918 lang=cpp
 * @lcpr version=20001
 *
 * [918] Maximum Sum Circular Subarray
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
#include <cassert>
// @lcpr-template-end
// @lc code=start

template <typename T>
class MonotonicQueue
{
private:
    deque<T> data;
    deque<T> maxData;

public:
    int size()
    {
        return data.size();
    }

    void push_back(T val)
    {
        data.push_back(val);
        // minData
        while (!maxData.empty() && maxData.back() > val)
        {
            maxData.pop_back();
        }
        maxData.push_back(val);
    }

    T pop_front()
    {
        assert(data.size() > 0);
        T val = data.front();
        data.pop_front();
        // minData
        if (!maxData.empty() && maxData.front() == val)
        {
            maxData.pop_front();
        }
        return val;
    }

    T min()
    {
        assert(data.size() > 0);
        return maxData.front();
    }
};

class Solution
{
public:
    int maxSubarraySumCircular(vector<int> &nums)
    {

        //--- 1. monotonic queue ---
        // {
        //     int n = nums.size();
        //     vector<int> preSum(2 * n + 1, 0);

        //     for (int i = 1; i < preSum.size(); i++)
        //     {
        //         preSum[i] = preSum[i - 1] + nums[(i - 1) % n];
        //     }

        //     int res = INT_MIN;
        //     MonotonicQueue<int> mq;
        //     mq.push_back(0);

        //     for (int i = 1; i < preSum.size(); i++)
        //     {
        //         res = max(res, preSum[i] - mq.min());

        //         if (mq.size() == n)
        //         {
        //             mq.pop_front();
        //         }

        //         mq.push_back(preSum[i]);
        //     }
        //     return res;
        // }

        //--- 2. dynamic programming 1 (best but tricky) ---
        // {
        //     int n = nums.size();
        //     int res = INT_MIN;
        //     int sum = 0;
        //     int maxSumDp0 = INT_MIN;
        //     int minSumDp0 = INT_MAX;
        //     int maxSum = INT_MIN;
        //     int minSum = INT_MAX;

        //     for (int i = 0; i < n; i++)
        //     {
        //         sum += nums[i];
        //         if (i == 0)
        //         {
        //             maxSumDp0 = nums[i];
        //             minSumDp0 = nums[i];
        //         }
        //         else
        //         {
        //             maxSumDp0 = max(maxSumDp0 + nums[i], nums[i]);
        //             minSumDp0 = min(minSumDp0 + nums[i], nums[i]);
        //         }
        //         maxSum = max(maxSum, maxSumDp0);
        //         minSum = min(minSum, minSumDp0);
        //     }

        //     if (maxSum < 0)
        //     {
        //         return maxSum;
        //     }
        //     else
        //     {
        //         return max(maxSum, sum - minSum);
        //     }

        //     return res;
        // }

        //--- 3. dynamic programming 2 (normal) ---
        // TODO:
        {

            int n = nums.size();

            // normalMax for normal subarray
            int normalMax = INT_MIN;
            int normalDp0 = 0;
            // leftSum
            vector<int> leftSum(n, 0);
            int sum = 0;

            for (int i = 0; i < n; i++)
            {
                sum += nums[i];

                // kadane's algorithm
                normalDp0 = max(nums[i], normalDp0 + nums[i]);
                normalMax = max(normalMax, normalDp0);

                // leftSum
                if (i == 0)
                {
                    leftSum[i] = nums[i];
                }
                else
                {
                    leftSum[i] = max(leftSum[i - 1], sum);
                }
            }

            int maxLeftRightSum = INT_MIN;
            // enumerate rightSum
            for (int i = 1; i < n; i++)
            {
                // rightSum
                sum -= nums[i - 1];
                maxLeftRightSum = max(maxLeftRightSum, leftSum[i - 1] + sum);
            }

            return max(normalMax, maxLeftRightSum);
        }
    }
};
// @lc code=end

/*
// @lcpr case=start
// [1,-2,3,-2]\n
// @lcpr case=end

// @lcpr case=start
// [5,-3,5]\n
// @lcpr case=end

// @lcpr case=start
// [-3,-2,-3]\n
// @lcpr case=end

 */

int main()
{
    Solution sol;
    vector<int> nums = {-3,-2,-3};
    cout << sol.maxSubarraySumCircular(nums) << endl;
    return 0;
}