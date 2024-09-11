/*
 * @lc app=leetcode id=1093 lang=cpp
 *
 * [1093] Statistics from a Large Sample
 */

#include <vector>
#include <iostream>

using namespace std;

// @lc code=start
class Solution
{
public:
    vector<double> sampleStats(vector<int> &count)
    {
        // for mean
        int total = 0;
        long long int sum = 0;
        // for median
        int lowCount = 0;
        int highCount = 0;
        int lowNum = 0;
        int highNum = 255;
        // for min and max
        bool foundMin = false;
        bool foundMax = false;
        double min = 256;
        double max = -1;
        // for mode
        double mode = -1;
        int modeCount = 0;

        for (int curLowNum = 0, curHighNum = 255; curLowNum <= curHighNum;)
        {
            if (lowCount <= highCount)
            {
                // take lowNum
                long long int fre = count[curLowNum];
                if (fre > 0)
                {
                    // min
                    if (!foundMin)
                    {
                        min = curLowNum;
                        foundMin = true;
                    }
                    // mode
                    if (fre > modeCount)
                    {
                        mode = curLowNum;
                        modeCount = fre;
                    }
                    // mean
                    total += fre;
                    sum += fre * curLowNum;
                    // median
                    lowCount += fre;
                    lowNum = curLowNum;
                }
                curLowNum++;
            }
            else
            {
                // take highNum
                long long int fre = count[curHighNum];
                if (fre > 0)
                {
                    // max
                    if (!foundMax)
                    {
                        max = curHighNum;
                        foundMax = true;
                    }
                    // mode
                    if (fre > modeCount)
                    {
                        mode = curHighNum;
                        modeCount = fre;
                    }
                    // mean
                    total += fre;
                    sum += fre * curHighNum;
                    // median
                    highCount += fre;
                    highNum = curHighNum;
                }
                curHighNum--;
            }
        }

        // mean
        double mean = (double)sum / total;
        // median
        double median = 0;
        if (highCount == lowCount)
        {
            median = (double(lowNum) + highNum) / 2;
        }
        else
        {
            median = highCount > lowCount ? highNum : lowNum;
        }

        return {min, max, mean, median, mode};
    }
};
// @lc code=end

int main()
{
    // vector<int> count(256, 0);
    // count[1] = 4;
    // count[2] = 3;
    // count[3] = 2;
    // count[4] = 2;

    vector<int> count = {264, 912, 1416, 1903, 2515, 3080, 3598, 4099, 4757, 5270, 5748, 6451, 7074, 7367, 7847, 8653, 9318, 9601, 10481, 10787, 11563, 11869, 12278, 12939, 13737, 13909, 14621, 15264, 15833, 16562, 17135, 17491, 17982, 18731, 19127, 19579, 20524, 20941, 21347, 21800, 22342, 21567, 21063, 20683, 20204, 19818, 19351, 18971, 18496, 17974, 17677, 17034, 16701, 16223, 15671, 15167, 14718, 14552, 14061, 13448, 13199, 12539, 12265, 11912, 10931, 10947, 10516, 10177, 9582, 9102, 8699, 8091, 7864, 7330, 6915, 6492, 6013, 5513, 5140, 4701, 4111, 3725, 3321, 2947, 2357, 1988, 1535, 1124, 664, 206, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    Solution sol;
    auto res = sol.sampleStats(count);
    for (auto r : res)
    {
        cout << r << " ";
    }
}