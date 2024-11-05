/*
 * @lc app=leetcode id=167 lang=cpp
 * @lcpr version=20002
 *
 * [167] Two Sum II - Input Array Is Sorted
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
    vector<int> twoSum(vector<int> &numbers, int target)
    {
        int start = 1;
        int end = numbers.size();

        while (start < end)
        {
            auto sum = numbers[start - 1] + numbers[end - 1];
            if (sum == target)
            {
                return vector({start, end});
            }
            else if (sum < target)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return vector({0});
    }
};
// @lc code=end

/*
// @lcpr case=start
// [2,7,11,15]\n9\n
// @lcpr case=end

// @lcpr case=start
// [2,3,4]\n6\n
// @lcpr case=end

// @lcpr case=start
// [-1,0]\n-1\n
// @lcpr case=end

 */
