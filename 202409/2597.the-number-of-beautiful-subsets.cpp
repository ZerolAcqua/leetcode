/*
 * @lc app=leetcode id=2597 lang=cpp
 *
 * [2597] The Number of Beautiful Subsets
 */

#include <algorithm>
#include <iostream>
#include <vector>
#include <map>
#include <cmath>

using namespace std;

// @lc code=start
class Solution
{
public:
  int beautifulSubsets(vector<int> &nums, int k)
  {
    // return recursiveBeautifulSubsets(nums, k);
    return dpBeautifulSubsets(nums, k);
  }

  // -- recursive --
  int recursiveBeautifulSubsets(vector<int> &nums, int diff)
  {
    return countBeautifulSubsets(nums, diff, 0, 0u);
  }

private:
  int countBeautifulSubsets(vector<int> &subset, int diff, int idx, unsigned int state)
  {
    if (subset.size() == idx)
    {
      return state > 0;
    }

    bool isBeautiful = true;

    for (int i = 0; i < idx; i++)
    {
      isBeautiful &= (state & 1 << i) == 0 || (abs(subset[i] - subset[idx]) != diff);
    }

    int skip = countBeautifulSubsets(subset, diff, idx + 1, state);
    int take = 0;
    if (isBeautiful)
    {
      take = countBeautifulSubsets(subset, diff, idx + 1, state | 1u << idx);
    }
    return skip + take;
  }

public:
  // -- grouped dp --
  int dpBeautifulSubsets(vector<int> &nums, int diff)
  {
    int total = 1;
    map<int, map<int, int>> freqMap;

    for (int &num : nums)
    {
      freqMap[num % diff][num]++;
    }

    for (auto &fr : freqMap)
    {
      vector<pair<int, int>> subsets(fr.second.begin(), fr.second.end());
      int n = subsets.size();

      int curr = 0, prev1 = 1, prev2 = 1;
      int prevNum = -diff;

      for (auto &[num, freq]: fr.second)
      {
        int skip = prev1;
        int take = (1 << freq) - 1;
        if (num - prevNum== diff)
        {
          take *= prev2;
        }
        else
        {
          take *= prev1;
        }
        curr = skip + take;
        prev2 = prev1;
        prev1 = curr;
        prevNum = num;
      }
      total *= curr;
    }

    return total - 1;
  }
};
// @lc code=end

int main()
{
  vector<int> nums = {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
  int k = 1;
  Solution sol;
  cout << sol.beautifulSubsets(nums, k) << endl;
}
