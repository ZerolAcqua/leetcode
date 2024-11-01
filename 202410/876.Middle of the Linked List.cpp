/*
 * @lc app=leetcode id=876 lang=cpp
 * @lcpr version=20002
 *
 * [876] Middle of the Linked List
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

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


// @lcpr-template-end
// @lc code=start

class Solution
{
public:
    ListNode *middleNode(ListNode *head)
    {
        auto p1 = head;
        auto p2 = head;

        int i = 0;
        while (p1 != nullptr)
        {
            p1 = p1->next;
            i++;
            if (i % 2 == 0)
            {
                p2 = p2->next;
            }
        }

        return p2;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,6]\n
// @lcpr case=end

 */
