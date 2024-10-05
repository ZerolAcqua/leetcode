/*
 * @lc app=leetcode id=707 lang=cpp
 *
 * [707] Design Linked List
 */

#include <iostream>

// @lc code=start

struct MyListNode
{
    int val;
    MyListNode *next = nullptr;
    MyListNode() : val(0), next(nullptr) {};
    MyListNode(int x) : val(x), next(nullptr) {};
    MyListNode(int x, MyListNode *next) : val(x), next(next) {};
};

class MyLinkedList
{
public:
    MyLinkedList()
    {
    }

    int get(int index)
    {
        if (index < 0 || index >= size)
        {
            return -1;
        }

        auto curr = dummy->next;
        for (int i = 0; i < index; i++)
        {
            curr = curr->next;
        }
        return curr->val;
    }

    void addAtHead(int val)
    {
        dummy->next = new MyListNode(val, dummy->next);
        size++;
    }

    void addAtTail(int val)
    {
        auto curr = dummy;
        while (curr->next != nullptr)
        {
            curr = curr->next;
        }
        curr->next = new MyListNode(val);
        size++;
    }

    void addAtIndex(int index, int val)
    {
        if (index < 0 || index > size)
        {
            return;
        }

        auto curr = dummy;

        for (int i = 0; i < index; i++)
        {
            curr = curr->next;
        }
        curr->next = new MyListNode(val, curr->next);
        size++;
    }

    void deleteAtIndex(int index)
    {
        if (index < 0 || index >= size)
        {
            return;
        }

        auto curr = dummy;
        for (int i = 0; i < index; i++)
        {
            curr = curr->next;
        }
        auto temp = curr->next;
        curr->next = temp->next;
        
        delete temp;
        size--;
    }

private:
    int size = 0;
    MyListNode *dummy = new MyListNode();
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */
// @lc code=end
