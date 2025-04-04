/*
 * @lc app=leetcode id=160 lang=cpp
 * @lcpr version=20002
 *
 * [160] Intersection of Two Linked Lists
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

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

// @lcpr-template-end
// @lc code=start

class Solution
{
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB)
    {
        auto p1 = headA;
        auto p2 = headB;
        while (p1 != p2)
        {
            if (p1 == nullptr)
            {
                p1 = headB;
            }
            if (p2 == nullptr)
            {
                p2 = headA;
            }
            if (p1 == p2)
                break;
            p1 = p1->next;
            p2 = p2->next;
        }
        return p1;
    }
};
// @lc code=end

/*
// @lcpr case=start
// 8\n[4,1,8,4,5]\n[5,6,1,8,4,5]\n2\n3\n
// @lcpr case=end

// @lcpr case=start
// 2\n[1,9,1,2,4]\n[3,2,4]\n3\n1\n
// @lcpr case=end

// @lcpr case=start
// 0\n[2,6,4]\n[1,5]\n3\n2\n
// @lcpr case=end

 */
