/*
 * @lc app=leetcode id=1425 lang=cpp
 * @lcpr version=20002
 *
 * [1425] Constrained Subsequence Sum
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

public:
    int size()
    {
        return data.size();
    }

    void push_back(int val)
    {
        data.push_back(val);
        while (maxData.size() > 0 && maxData.back() < val)
        {
            maxData.pop_back();
        }
        maxData.push_back(val);
    }

    int pop_front()
    {
        int val = data.front();
        data.pop_front();

        if (val == maxData.front())
        {
            maxData.pop_front();
        }

        return val;
    }

    int max()
    {
        return maxData.front();
    }
};

class Solution
{
public:
    int constrainedSubsetSum(vector<int> &nums, int k)
    {
        MonotonicQueue mq;
        int res = INT_MIN;
        for (int i = 0; i < nums.size(); i++)
        {
            if (i == 0)
            {
                mq.push_back(nums[i]);
            }
            else if (mq.size() < k)
            {
                mq.push_back(max(nums[i], nums[i] + mq.max()));
            }
            else
            {
                mq.push_back(max(nums[i], nums[i] + mq.max()));
                mq.pop_front();
            }
            res = max(res, mq.max());
        }
        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [10,2,-10,5,20]\n2\n
// @lcpr case=end

// @lcpr case=start
// [-1,-2,-3]\n1\n
// @lcpr case=end

// @lcpr case=start
// [10,-2,-10,-5,20]\n2\n
// @lcpr case=end

 */

int main()
{
    std::vector<int> nums = {10, -2, -10, -5, 20};
    int k = 2;
    Solution sol;
    cout << sol.constrainedSubsetSum(nums, k) << endl;
}
