/*
 * @lc app=leetcode id=46 lang=cpp
 * @lcpr version=20002
 *
 * [46] Permutations
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
    vector<vector<int>> permute(vector<int> &nums)
    {
        int n = nums.size();
        vector<bool> used(n, false);
        vector<int> track;
        backtrack(nums, used, track);
        return res;
    }

    void backtrack(vector<int> &nums, vector<bool> &used, vector<int> &track)
    {
        if (track.size() == nums.size())
        {
            res.push_back(track);
            return;
        }

        for (int i = 0; i < nums.size(); i++)
        {
            if (used[i])
                continue;
            track.push_back(nums[i]);
            used[i] = true;
            backtrack(nums, used, track);
            track.pop_back();
            used[i] = false;
        }
    }

private:
    vector<vector<int>> res;
};
// @lc code=end

/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0,1]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */
