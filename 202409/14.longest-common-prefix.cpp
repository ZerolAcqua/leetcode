/*
 * @lc app=leetcode id=14 lang=cpp
 *
 * [14] Longest Common Prefix
 */

#include <iostream>
#include <string>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
public:
  string longestCommonPrefix(vector<string> &strs) {
    if (strs.size() == 1) {
      return strs[0];
    }

    string commonStr = "";
    for (int idx = 0; idx < 200; idx++) {
      string firstStr = strs[0];

      for (auto str : strs) {
        if (firstStr.size() <= idx || str.size() <= idx) {
          return commonStr;
        }
        if (firstStr[idx] != str[idx]) {
          return commonStr;
        }

        // 检查公共的子串相同，就看下一字符串
      }
      commonStr += firstStr[idx];
    }

    return commonStr;
  }
};
// @lc code=end

int main() {
  Solution sol;
  vector<string> strs = {"", ""};
  cout << sol.longestCommonPrefix(strs) << endl;
  return 0;
}