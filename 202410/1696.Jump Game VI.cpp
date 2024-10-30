/*
 * @lc app=leetcode id=1696 lang=cpp
 * @lcpr version=20002
 *
 * [1696] Jump Game VI
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
        // maxData
        while (!maxData.empty() && maxData.back() < val)
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
        // maxData
        if (!maxData.empty() && maxData.front() == val)
        {
            maxData.pop_front();
        }
        return val;
    }

    T back()
    {
        assert(data.size() > 0);
        return data.back();
    }

    T max()
    {
        assert(data.size() > 0);
        return maxData.front();
    }
};

class Solution
{
public:
    int maxResult(vector<int> &nums, int k)
    {
        MonotonicQueue<int> mq;
        for (int i = 0; i < nums.size(); i++)
        {
            if (i == 0)
            {
                mq.push_back(nums[i]);
            }
            else if (mq.size() < k)
            {
                mq.push_back(mq.max() + nums[i]);
            }
            else
            {
                mq.push_back(mq.max() + nums[i]);
                mq.pop_front();
            }
        }
        return mq.back();
    }
};
// @lc code=end

/*
// @lcpr case=start
// [1,-1,-2,4,-7,3]\n2\n
// @lcpr case=end

// @lcpr case=start
// [10,-5,-2,4,0,3]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1,-5,-20,4,-1,3,-6,-3]\n2\n
// @lcpr case=end

 */
