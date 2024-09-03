/*
 * @lc app=leetcode id=69 lang=cpp
 *
 * [69] Sqrt(x)
 */

#include <math.h>
#include <iostream>

using namespace std;

// @lc code=start
class Solution {
public:
    int mySqrt(int x) {
        double nLastNum = 0;
        double nCurNum = x;
        while(fabs(nLastNum-nCurNum)> 1e-2)
        {
            nLastNum = nCurNum;
            nCurNum = (nCurNum + x/nCurNum)/2;
        }
        return int(nCurNum);
    }
};
// @lc code=end


int main()
{
    Solution sol;
    cout << sol.mySqrt(16) << endl;
    return 0;
}
