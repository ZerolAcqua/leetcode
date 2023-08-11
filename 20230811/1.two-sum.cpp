/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 */


#include "stdlib.h"
#include "vector"
#include "iostream"
#include "unordered_map"

using namespace std;


// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // 维护 val -> index 的映射
        unordered_map<int, int> valToIndex;
        for (int i = 0; i < nums.size(); i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.count(need)) {
                return vector<int>{valToIndex[need], i};
            }
            // 存入 val -> index 的映射
            valToIndex[nums[i]] = i;
        }
        return vector<int>{};
    }
};
// @lc code=end

int main()
{
    cout<<"hello world";
    return 0;
}