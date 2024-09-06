/*
 * @lc app=leetcode id=268 lang=cpp
 *
 * [268] Missing Number
 */

#include <vector>

using namespace std;


// @lc code=start
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int res = nums.size();

        for (int i = 0; i < nums.size(); i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
};
// @lc code=end

