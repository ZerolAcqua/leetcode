/*
 * @lc app=leetcode id=21 lang=cpp
 *
 * [21] Merge Two Sorted Lists
 */

#include <iostream>
#include <vector>

using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution
{
public:
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2)
    {
        ListNode *dummy = new ListNode();
        ListNode *curr = dummy;
        ListNode *p1 = list1;
        ListNode *p2 = list2;

        while (p1 != nullptr && p2 != nullptr)
        {
            if (p1->val < p2->val)
            {
                curr->next = p1;
                p1 = p1->next;
            }
            else
            {
                curr->next = p2;
                p2 = p2->next;
            }
            curr = curr->next;
        }

        if (p1 != nullptr)
        {
            curr->next = p1;
        }
        else
        {
            curr->next = p2;
        }
        return dummy->next;
    }
};
// @lc code=end
