/*
 * @lc app=leetcode id=371 lang=cpp
 *
 * [371] Sum of Two Integers
 */

#include <iostream>

using namespace std;

// @lc code=start
class Solution {
public:
  int getSum(int a, int b) { return b == 0 ? a : getSum(a ^ b, (a & b) << 1); }
};
// @lc code=end

int main() {
  Solution sol;
  cout << "result:" << sol.getSum(1, 2) << endl;
}