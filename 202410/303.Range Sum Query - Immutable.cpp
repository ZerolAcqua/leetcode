/*
 * @lc app=leetcode id=303 lang=cpp
 * @lcpr version=20001
 *
 * [303] Range Sum Query - Immutable
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
class NumArray
{
public:
    vector<int> sums;
    NumArray(vector<int> &nums)
    {
        int n = nums.size();
        sums.resize(n + 1);
        for (int i = 1; i < n + 1; i++)
        {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    int sumRange(int left, int right)
    {
        return sums[right + 1] - sums[left];
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */
// @lc code=end
