/*
 * @lc app=leetcode id=1108 lang=cpp
 *
 * [1108] Defanging an IP Address
 */

#include <string>
#include <iostream>
// #include <regex>

using namespace std;

// @lc code=start
class Solution {
public:
    // string defangIPaddr(string address) {
    //     return regex_replace(address, regex(R"(\.)"), "[.]");
    // }
    string defangIPaddr(string address) {
        string defanged = "";
        for (char c : address) {
            if (c == '.') {
                defanged += "[.]";
            } else {
                defanged += c;
            }
        }
        return defanged;
    }
};
// @lc code=end


int main(){
    string address = "1.1.1.1";
    Solution sol;
    cout << sol.defangIPaddr(address);
}
