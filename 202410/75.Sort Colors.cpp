/*
 * @lc app=leetcode id=75 lang=cpp
 * @lcpr version=20002
 *
 * [75] Sort Colors
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
    void sortColors(vector<int> &nums)
    {

        //-- 1. counting sort --
        // {
        //     int count[3] = {0};
        //     for (int i = 0; i < nums.size(); i++)
        //     {
        //         switch (nums[i])
        //         {
        //         case 0:
        //             count[0]++;
        //             break;
        //         case 1:
        //             count[1]++;
        //             break;
        //         case 2:
        //             count[2]++;
        //             break;
        //         }
        //     }
        //     int curIdx = 0;
        //     for (int i = 0; i < 3; i++)
        //     {
        //         for (int j = 0; j < count[i]; j++)
        //         {
        //             nums[curIdx] = i;
        //             curIdx++;
        //         }
        //     }
        //     return;
        // }

        //-- 2. three pointers --
        {
            int p = 0, p0 = 0, p1 = nums.size() - 1;
            while (p <= p1)
            {
                if (nums[p] == 0)
                {
                    swap(nums[p], nums[p0]);
                    p0++;
                }
                else if (nums[p] == 1)
                {
                    p++;
                }
                else
                {
                    swap(nums[p], nums[p1]);
                    p1--;
                }

                if (p < p0){
                    p = p0;
                }
            }
            return;
        }
    }
};
// @lc code=end

/*
// @lcpr case=start
// [2,0,2,1,1,0]\n
// @lcpr case=end

// @lcpr case=start
// [2,0,1]\n
// @lcpr case=end

 */
