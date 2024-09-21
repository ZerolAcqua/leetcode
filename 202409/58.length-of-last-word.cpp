/*
 * @lc app=leetcode id=58 lang=cpp
 *
 * [58] Length of Last Word
 */

#include <iostream>
#include <string>
using namespace std;

// @lc code=start
class Solution
{
public:
    int lengthOfLastWord(string s)
    {
        auto riter1 = s.rbegin();
        auto riter2 = s.rbegin();
        while (riter1 != s.rend() && *riter1 == ' ')
        {

            riter1++;
        }
        riter2 = riter1;
        while (riter2 != s.rend() && *riter2 != ' ')
        {
            riter2++;
        }

        return riter2 - riter1;
    }
};
// @lc code=end

int main()
{
    Solution s;
    cout << s.lengthOfLastWord("Hello Worfld  ") << endl;
    return 0;
}