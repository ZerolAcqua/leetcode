/*
 * @lc app=leetcode id=20 lang=cpp
 *
 * [20] Valid Parentheses
 */

#include <iostream>
#include <string>
#include <stack>

using namespace std;

// @lc code=start
class Solution
{
public:
    bool isValid(string s)
    {
        stack<char> st;
        for (auto &&c : s)
        {
            if (c == '(' || c == '[' || c == '{')
            {
                st.push(c);
            }
            else
            {
                if (st.empty())
                {
                    return false;
                }
                if (st.top() == '(' && c == ')' || st.top() == '[' && c == ']' || st.top() == '{' && c == '}')
                {
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.empty();
    }
};
// @lc code=end
