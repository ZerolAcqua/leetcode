/*
 * @lc app=leetcode id=239 lang=cpp
 * @lcpr version=20000
 *
 * [239] Sliding Window Maximum
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

// 使用单调队列
class MonotonicQueue
{
private:
    deque<int> data;

public:
    void push(int val)
    {
        while (!data.empty() && data.back() < val)
        {
            data.pop_back();
        }
        data.push_back(val);
    }
    void pop(int cur)
    {
        if (!data.empty() && data.front() == cur)
        {
            data.pop_front();
        }
    }
    int max()
    {
        return data.front();
    }
};

class Solution
{
public:
    vector<int>
    maxSlidingWindow(vector<int> &nums, int k)
    {
        MonotonicQueue window;
        vector<int> res;

        for (int i = 0; i < nums.size(); i++)
        {
            if (i < k - 1)
            {
                window.push(nums[i]);
            }
            else
            {
                window.push(nums[i]);
                res.push_back(window.max());
                window.pop(nums[i - k + 1]);
            }
        }

        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [1,3,-1,-3,5,3,6,7]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

 */
