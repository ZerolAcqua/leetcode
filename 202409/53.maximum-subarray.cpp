/*
 * @lc app=leetcode id=53 lang=cpp
 *
 * [53] Maximum Subarray
 */

#include <vector>
#include <climits>
#include <algorithm>

using namespace std;

// @lc code=start
class Solution
{
public:
    //
    int maxSubArray(vector<int> &nums)
    {
        // 分治法
        // return recursiveFindMaxSubarray(nums, 0, nums.size() - 1);

        // 动态规划
        // return dpFindMaxSubarray(nums);

        // kadane算法
        return kadaneFindMaxSubarray(nums);
    }

    // -- 分治法 --
    int recursiveFindMaxSubarray(vector<int> &nums, int low, int high)
    {
        return findMaxSubarray(nums, low, high);
    }

    // 没有跨越中点的最大子数组
    int findMaxSubarray(vector<int> &nums, int low, int high)
    {
        if (low == high)
        {
            return nums[low];
        }
        int mid = (low + high) / 2;
        int leftSum = findMaxSubarray(nums, low, mid);
        int rightSum = findMaxSubarray(nums, mid + 1, high);
        int crossSum = findMaxSubarray(nums, low, mid, high);
        return std::max({leftSum, rightSum, crossSum});
    }

    // 跨越中点的最大子数组
    int findMaxSubarray(vector<int> &nums, int low, int mid, int high)
    {
        int leftSum = INT_MIN;
        int rightSum = INT_MIN;
        for (int i = mid, sum = 0; i >= low; i--)
        {
            sum += nums[i];
            if (sum > leftSum)
            {
                leftSum = sum;
            }
        }
        for (int i = mid + 1, sum = 0; i <= high; i++)
        {
            sum += nums[i];
            if (sum > rightSum)
            {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    // -- 动态规划 --
    int dpFindMaxSubarray(vector<int> &nums)
    {
        int n = nums.size();
        vector<int> dp(n, 0);
        dp[0] = nums[0];
        for (int i = 1; i < n; i++)
        {
            dp[i] = std::max(dp[i - 1] + nums[i], nums[i]);
        }
        return *std::max_element(dp.begin(), dp.end());
    }

    // -- kadane算法 --
    int kadaneFindMaxSubarray(vector<int> &nums)
    {
        int n = nums.size();
        int lastSum = 0;
        int maxSum = INT_MIN;
        for (int i = 0; i < n; i++)
        {
            lastSum += nums[i];
            maxSum = std::max(maxSum, lastSum);
            if (lastSum < 0)
            {
                lastSum = 0;
            }
        }

        return maxSum;
    }
};
// @lc code=end

int main()
{
    Solution s;
    vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int result = s.maxSubArray(nums);
    return 0;
}
