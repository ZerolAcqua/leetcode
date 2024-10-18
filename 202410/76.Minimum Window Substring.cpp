/*
 * @lc app=leetcode id=76 lang=cpp
 * @lcpr version=20001
 *
 * [76] Minimum Window Substring
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
    string minWindow(string s, string t)
    {
        unordered_map<char, int> window;
        unordered_map<char, int> need;

        // init need
        for (auto &&c : t)
        {
            need[c]++;
        }

        // substring
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = INT_MAX;

        while (right < s.size())
        {
            auto c = s[right];
            if (need.count(c))
            {
                window[c]++;
                if (window[c] == need[c])
                {
                    valid++;
                }
            }
            right++;

            while (valid == need.size())
            {
                if (right - left < len)
                {
                    start = left;
                    len = right - left;
                }

                auto d = s[left];
                left++;

                if (need.count(d))
                {
                    if (window[d] == need[d])
                    {
                        valid--;
                    }
                    window[d]--;
                }
            }
        }

        return len == INT_MAX ? "" : s.substr(start, len);
    }
};
// @lc code=end

/*
// @lcpr case=start
// "ADOBECODEBANC"\n"ABC"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"a"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"aa"\n
// @lcpr case=end

 */

int main()
{
}