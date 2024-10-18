/*
 * @lc app=leetcode id=1438 lang=cpp
 * @lcpr version=20001
 *
 * [1438] Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
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

class MonotonicQueue
{
private:
    deque<int> data;
    deque<int> maxData;
    deque<int> minData;

public:
    int size()
    {
        return data.size();
    }

    void push_back(int val)
    {
        data.push_back(val);
        // maxData
        while (!maxData.empty() && maxData.back() < val)
        {
            maxData.pop_back();
        }
        maxData.push_back(val);
        // minData
        while (!minData.empty() && minData.back() > val)
        {
            minData.pop_back();
        }
        minData.push_back(val);
    }

    int pop_front()
    {
        int val = data.front();
        data.pop_front();
        // maxData
        if (!maxData.empty() && maxData.front() == val)
        {
            maxData.pop_front();
        }
        // minData
        if (!minData.empty() && minData.front() == val)
        {
            minData.pop_front();
        }
        return val;
    }

    int max()
    {
        return maxData.front();
    }

    int min()
    {
        return minData.front();
    }
};

class Solution
{
public:
    int longestSubarray(vector<int> &nums, int limit)
    {
        MonotonicQueue window;
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++)
        {
            window.push_back(nums[i]);
            if (window.max() - window.min() <= limit)
            {
                res = max(res, window.size());
            }
            else
            {
                window.pop_front();
            }
        }
        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [8,2,4,7]\n4\n
// @lcpr case=end

// @lcpr case=start
// [10,1,2,4,7,2]\n5\n
// @lcpr case=end

// @lcpr case=start
// [4,2,2,2,4,4,2,2]\n0\n
// @lcpr case=end

 */

int main()
{
    Solution sol;
    vector<int> nums = {8, 2, 4, 7};
    int limit = 4;
    cout << sol.longestSubarray(nums, limit) << endl;
    return 0;
}
