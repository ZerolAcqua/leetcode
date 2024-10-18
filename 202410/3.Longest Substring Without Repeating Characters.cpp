/*
 * @lc app=leetcode id=3 lang=cpp
 * @lcpr version=20001
 *
 * [3] Longest Substring Without Repeating Characters
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
    int lengthOfLongestSubstring(string s)
    {
        unordered_map<char, int> window;
        int res = 0;

        // substring
        int left = 0, right = 0;

        while (right < s.size())
        {
            auto c = s[right];
            right++;
            window[c]++;

            while (window[c] > 1)
            {
                auto d = s[left];
                left++;
                window[d]--;
            }

            res = max(res, right - left);
        }
        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

// @lcpr case=start
// "bbbbb"\n
// @lcpr case=end

// @lcpr case=start
// "pwwkew"\n
// @lcpr case=end

 */

int main()
{
    Solution s;
    cout << s.lengthOfLongestSubstring(" ") << endl;
    cout << s.lengthOfLongestSubstring("abcabcbb") << endl;
    cout << s.lengthOfLongestSubstring("bbbbb") << endl;
    cout << s.lengthOfLongestSubstring("pwwkew") << endl;
    return 0;
}