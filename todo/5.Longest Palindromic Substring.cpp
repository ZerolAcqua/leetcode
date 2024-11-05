/*
 * @lc app=leetcode id=5 lang=cpp
 * @lcpr version=20002
 *
 * [5] Longest Palindromic Substring
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
    string longestPalindrome(string s)
    {
        // === 1. 朴素算法 O(n^2) ===
        int n = s.size();
        string res;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++)
        {
            auto str1 = longestPalindromic(s, i, i);
            auto str2 = longestPalindromic(s, i, i + 1);
            res = res.size() > str1.size() ? res : str1;
            res = res.size() > str2.size() ? res : str2;
        }
        return res;

        // === 2. 动态规划 O(n^2) ===

        // === 3. Manacher 算法 O(n) ===
        
    }

private:
    // 朴素算法工具函数
    string longestPalindromic(const string &str, int left, int right)
    {
        while (left >= 0 && right < str.size() && str[left] == str[right])
        {
            left--;
            right++;
        }
        return str.substr(left + 1, right - 1 - left);
    }
};
// @lc code=end

/*
// @lcpr case=start
// "babad"\n
// @lcpr case=end

// @lcpr case=start
// "cbbd"\n
// @lcpr case=end

 */
