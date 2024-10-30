/*
 * @lc app=leetcode id=797 lang=cpp
 * @lcpr version=20001
 *
 * [797] All Paths From Source to Target
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
private:
    vector<vector<int>> res;
    vector<int> path;

public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>> &graph)
    {
        dfs(graph, 0);
        return res;
    }

    void dfs(vector<vector<int>> &graph, int id)
    {
        path.push_back(id);

        // base case

        if (id == graph.size() - 1)
        {
            res.push_back(path);
            path.pop_back();
            return;
        }

        // recursive
        for (auto &&node : graph[id])
        {
            dfs(graph, node);
        }
        path.pop_back();
    }
};
// @lc code=end

/*
// @lcpr case=start
// [[1,2],[3],[3],[]]\n
// @lcpr case=end

// @lcpr case=start
// [[4,3,1],[3,2,4],[3],[4],[]]\n
// @lcpr case=end

 */
