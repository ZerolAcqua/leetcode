/*
 * @lc app=leetcode id=19 lang=cpp
 * @lcpr version=20002
 *
 * [19] Remove Nth Node From End of List
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
    ListNode *removeNthFromEnd(ListNode *head, int n)
    {
        auto dummy = new ListNode(-1);
        dummy->next = head;
        auto p1 = dummy;
        auto p2 = dummy;

        for (int i = 0; i <= n; i++)
        {
            p1 = p1->next;
        }

        while (p1 != nullptr)
        {
            p1 = p1->next;
            p2 = p2->next;
        }

        auto tmp = p2->next;
        p2->next = p2->next->next;
        delete tmp;

        return dummy->next;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n
// @lcpr case=end

 */
