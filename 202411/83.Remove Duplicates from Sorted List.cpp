/*
 * @lc app=leetcode id=83 lang=cpp
 * @lcpr version=20002
 *
 * [83] Remove Duplicates from Sorted List
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
    ListNode *deleteDuplicates(ListNode *head)
    {
        if (head == nullptr)
        {
            return head;
        }

        auto slow = head;
        auto fast = head;
        while (fast != nullptr)
        {
            if (slow->val == fast->val)
            {
                fast = fast->next;
            }
            else
            {
                for (auto p = slow->next; p != nullptr && p != fast;)
                {
                    auto temp = p;
                    p = p->next;
                    delete temp;
                }
                slow->next = fast;
                slow = fast;
            }
        }

        auto temp = slow->next;
        slow->next = nullptr;
        slow = temp;

        while (slow != nullptr)
        {
            auto temp = slow->next;
            delete slow;
            slow = temp;
        }

        return head;
    }
};
// @lc code=end

/*
// @lcpr case=start
// [1,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,2,3,3]\n
// @lcpr case=end

 */
