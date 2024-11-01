/*
 * @lc app=leetcode id=142 lang=cpp
 * @lcpr version=20002
 *
 * [142] Linked List Cycle II
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
    ListNode(int x) : val(x), next(NULL) {}
};



// @lcpr-template-end
// @lc code=start

class Solution
{
public:
    ListNode *detectCycle(ListNode *head)
    {
        auto p1 = head;
        auto p2 = head;

        while (p2 != nullptr && p2->next != nullptr)
        {
            p1 = p1->next;
            p2 = p2->next->next;
            if (p1 == p2)
            {
                break;
            }
        }

        if (p2 == nullptr || p2->next == nullptr)
        {
            return nullptr;
        }

        p1 = head;
        while (p1 != p2)
        {
            p1 = p1->next;
            p2 = p2->next;
        }
        return p1;
    }
};

// @lc code=end

/*
// @lcpr case=start
// [3,2,0,-4]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [1]\n-1\n
// @lcpr case=end

 */
