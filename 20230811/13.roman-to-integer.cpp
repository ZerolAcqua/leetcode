/*
 * @lc app=leetcode id=13 lang=cpp
 *
 * [13] Roman to Integer
 */

#include <iostream>
#include <unordered_map>

using namespace std;

// @lc code=start
class Solution
{
public:
    // int romanToInt(string s)
    // {
    //     // define the map for roman to integer
    //     unordered_map<char, int> map;
    //     // for unexisted key, the value is 0, no need to define
    //     // map['\0'] = 0;
    //     map['I'] = 1;
    //     map['V'] = 5;
    //     map['X'] = 10;
    //     map['L'] = 50;
    //     map['C'] = 100;
    //     map['D'] = 500;
    //     map['M'] = 1000;

    //     int ans = 0;
    //     for (int i = 0; i < s.length(); i++)
    //     {
    //         if (map[s[i]] < map[s[i + 1]])
    //         {
    //             ans -= map[s[i]];
    //         }
    //         else
    //         {
    //             ans += map[s[i]];
    //         }
    //     }
    //     return ans;
    // }

    int romanToInt(string s)
    {
        int digit = 0;
        int digit_next = 0;
        int ans = 0;
        for (int i = 0; i <= s.length(); i++)
        {
            digit=digit_next;
            digit_next=getDigit(s[i]);
            if(digit<digit_next)
            {
                ans-=digit;
            }
            else
            {
                ans+=digit;
            }
        }
        return ans;
    }

    int getDigit(char s)
    {
        switch (s)
        {
        case 'I':
            return 1;
            break;
        case 'V':
            return 5;
            break;
        case 'X':
            return 10;
            break;
        case 'L':
            return 50;
            break;
        case 'C':
            return 100;
            break;
        case 'D':
            return 500;
            break;
        case 'M':
            return 1000;
            break;
        default:
            return 0;
            break;
        }
    }
};
// @lc code=end

int main()
{
    Solution sol;
    unordered_map<char, int> map;
    // map['\0'] = 0;
    map['I'] = 1;
    map['V'] = 5;
    map['X'] = 10;
    map['L'] = 50;
    map['C'] = 100;
    map['D'] = 500;
    map['M'] = 1000;
    cout << map[1] << endl;
    cout << sol.romanToInt("III") << endl;
    cout << sol.romanToInt("IV") << endl;
    cout << sol.romanToInt("IX") << endl;
    cout << sol.romanToInt("LVIII") << endl;
    cout << sol.romanToInt("MCMXCIV") << endl;
    return 0;
}