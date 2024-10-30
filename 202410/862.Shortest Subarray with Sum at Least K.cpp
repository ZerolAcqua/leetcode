/*
 * @lc app=leetcode id=862 lang=cpp
 * @lcpr version=20001
 *
 * [862] Shortest Subarray with Sum at Least K
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
        return maxData.front();
    }
};

class Solution
{
public:
    int shortestSubarray(vector<int> &nums, int k)
    {

        int n = nums.size();
        vector<long> preSum(n + 1, 0);
        for (int i = 1; i < preSum.size(); i++)
        {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = INT_MAX;

        MonotonicQueue<long> mq;

        int left = 0, right = 0;

        while (right < preSum.size())
        {
            mq.push_back(preSum[right]);
            right++;

            while (right < preSum.size() && mq.size() != 0 && preSum[right] - mq.min() >= k)
            {
                res = min(res, right - left);
                mq.pop_front();
                left++;
            }
        }

        return res == INT_MAX ? -1 : res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n4\n
// @lcpr case=end

// @lcpr case=start
// [2,-1,2]\n3\n
// @lcpr case=end

 */

int main()
{
    Solution sol;
    vector<int> nums = {2, -1, 2};
    int k = 3;
    cout << sol.shortestSubarray(nums, k) << endl;
    return 0;
}