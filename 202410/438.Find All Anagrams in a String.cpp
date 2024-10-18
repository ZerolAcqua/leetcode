/*
 * @lc app=leetcode id=438 lang=cpp
 * @lcpr version=20001
 *
 * [438] Find All Anagrams in a String
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
    vector<int> findAnagrams(string s, string p)
    {
        unordered_map<char, int> window;
        unordered_map<char, int> need;
        vector<int> res;

        // init need
        for (auto &&c : p)
        {
            need[c]++;
        }

        // substring
        int left = 0, right = 0;
        int valid = 0;

        while (right < s.size())
        {
            auto c = s[right];
            right++;

            if(need.count(c)){
                window[c]++;
                if (window[c] == need[c])
                {
                    valid++;
                }
            }
            else{
                window.clear();
                valid = 0;
                left = right;
            }

            while (right - left >= p.size())
            {
                if (valid == need.size())
                {
                    res.push_back(left);
                }

                auto d = s[left];
                left++;
                if(need.count(d)){
                    if (window[d] == need[d])
                    {
                        valid--;
                    }
                    window[d]--;
                }
            }
        }
        return res;
    }
};
// @lc code=end

/*
// @lcpr case=start
// "cbaebabacd"\n"abc"\n
// @lcpr case=end

// @lcpr case=start
// "abab"\n"ab"\n
// @lcpr case=end

 */
