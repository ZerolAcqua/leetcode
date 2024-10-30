/*
 * @lc app=leetcode id=86 lang=cpp
 * @lcpr version=20002
 *
 * [86] Partition List
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
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

// @lcpr-template-end
// @lc code=start

class Solution
{
public:
    ListNode *partition(ListNode *head, int x)
    {
        ListNode *dummy1 = new ListNode(-1);
        ListNode *dummy2 = new ListNode(-1);
        auto *p1 = dummy1;
        auto *p2 = dummy2;
        auto p = head;
        while (p != nullptr)
        {
            if (p->val < x)
            {
                p1->next = p;
                p1 = p1->next;
            }
            else
            {
                p2->next = p;
                p2 = p2->next;
            }
            auto temp = p->next;
            p->next = nullptr;
            p = temp;
        }
        p1->next = dummy2->next;
        return dummy1->next;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [1,4,3,2,5,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [2,1]\n2\n
// @lcpr case=end

 */
