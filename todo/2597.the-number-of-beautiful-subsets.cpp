/*
 * @lc app=leetcode id=2597 lang=cpp
 *
 * [2597] The Number of Beautiful Subsets
 */

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
public:
  int beautifulSubsets(vector<int> &nums, int k) {
    int n = nums.size();
    return 0;
  }
};
// @lc code=end

int main() {
  vector<int> nums = {2, 4, 6};
  int k = 2;
  Solution sol;
  cout << sol.beautifulSubsets(nums, 2) << endl;
}
