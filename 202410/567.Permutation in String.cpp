/*
 * @lc app=leetcode id=567 lang=cpp
 * @lcpr version=20001
 *
 * [567] Permutation in String
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
class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        unordered_map<char, int> window;
        unordered_map<char, int> need;

        // init need
        for (auto &&c : s1)
        {
            need[c]++;
        }

        // substring
        int left = 0, right = 0;
        int valid = 0;

        while(right<s2.size())
        {
            auto c = s2[right];
            right++;
            if (need.count(c))
            {
                window[c]++;
                if (window[c] == need[c])
                {
                    valid++;
                }
            }
            else
            {
                window.clear();
                valid = 0;
                left = right;
                continue;
            }

            while (right - left >= s1.size())
            {
                if (valid == need.size())
                {
                    return true;
                }
                auto d = s2[left];
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

        return false;
    }
};
// @lc code=end



/*
// @lcpr case=start
// "ab"\n"eidbaooo"\n
// @lcpr case=end

// @lcpr case=start
// "ab"\n"eidboaoo"\n
// @lcpr case=end

 */
