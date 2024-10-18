/*
 * @lc app=leetcode id=1453 lang=cpp
 *
 * [1453] Maximum Number of Darts Inside of a Circular Dartboard
 */

#include <vector>
#include <iostream>
#include <unordered_map>
#include <complex>
#include <algorithm>

using namespace std;

// @lc code=start

typedef complex<double> Point;

class Solution
{
public:
    int numPoints(vector<vector<int>> &darts, int r)
    {

        int maxPoints = 1;
        vector<pair<Point, bool>> intervals;
        auto comp = [](pair<Point, bool> a, pair<Point, bool> b)
        {
            if (a.first.real() == b.first.real())
            {
                return a.second;
            }
            return a.first.real() < b.first.real();
        };

        for (auto &&dart : darts)
        {

            Point p(dart[0], dart[1]);

            for (auto &&dart2 : darts)
            {

                Point q(dart2[0], dart2[1]);
                if (p == q)
                {
                    continue;
                }
                double mag = abs(q - p);
                if (mag > 2 * r)
                {
                    continue;
                }
                double centralAngle = arg(q - p);
                double theta = acos(mag / (2 * r));
                double start = centralAngle - theta;
                double end = centralAngle + theta;
                intervals.push_back({start, true});
                intervals.push_back({end, false});
            }

            sort(intervals.begin(), intervals.end(), comp);

            int points = 1;
            for (auto &&interval : intervals)
            {
                if (interval.second)
                {
                    points++;
                }
                else
                {
                    points--;
                }
                maxPoints = max(maxPoints, points);
            }

            intervals.clear();
        }

        return maxPoints;
    }
};
// @lc code=end
