/*
 * @lc app=leetcode id=23 lang=cpp
 *
 * [23] Merge k Sorted Lists
 */

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct MyListNode
{
    int val;
    MyListNode *next;
    MyListNode() : val(0), next(nullptr) {}
    MyListNode(int x) : val(x), next(nullptr) {}
    MyListNode(int x, MyListNode *next) : val(x), next(next) {}
};

// @lc code=start
class Solution
{
public:
    MyListNode *mergeKLists(vector<MyListNode *> &lists)
    {
        if (lists.size() == 0)
        {
            return nullptr;
        }

        MyListNode *dummy = new MyListNode();
        MyListNode *curr = dummy;
        auto cmp = [](MyListNode *a, MyListNode *b)
        { return a->val > b->val; };
        priority_queue<MyListNode *, vector<MyListNode *>, decltype(cmp)> pq(cmp);

        for (MyListNode *list : lists)
        {
            if (list != nullptr)
            {
                pq.push(list);
            }
        }

        while (!pq.empty())
        {
            MyListNode *top = pq.top();
            pq.pop();
            curr->next = top;
            curr = curr->next;
            if (top->next != nullptr)
            {
                pq.push(top->next);
            }
        }

        return dummy->next;
    }
};
// @lc code=end
