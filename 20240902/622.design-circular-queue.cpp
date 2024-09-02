/*
 * @lc app=leetcode id=622 lang=cpp
 *
 * [622] Design Circular Queue
 */

#include <iostream>

using namespace std;

// @lc code=start
class MyCircularQueue
{
public:
    MyCircularQueue(int k)
    {
        data = new int[k];
        head = 0;
        tail = 0;
        size = 0;
        capacity = k;
    }

    ~MyCircularQueue()
    {
        delete[] data;
    }

    bool enQueue(int value)
    {
        if (isFull())
        {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % capacity;
        size++;

        return true;
    }

    bool deQueue()
    {
        if (isEmpty())
        {
            return false;
        }
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    int Front()
    {
        return isEmpty() ? -1 : data[head];
    }

    int Rear()
    {
        return isEmpty() ? -1 : data[(tail + capacity - 1) % capacity];
    }

    bool isEmpty()
    {
        return size == 0;
    }

    bool isFull()
    {
        return size == capacity;
    }

protected:
    int *data;
    int head;
    int tail;
    int size;
    int capacity;
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */
// @lc code=end

int main()
{
    MyCircularQueue myCircularQueue = MyCircularQueue(3);
    myCircularQueue.enQueue(1); // return True
    myCircularQueue.enQueue(2); // return True
    myCircularQueue.enQueue(3); // return True
    myCircularQueue.enQueue(4); // return False
    myCircularQueue.Rear();     // return 3
    myCircularQueue.isFull();   // return True
    myCircularQueue.deQueue();  // return True
    myCircularQueue.enQueue(4); // return True
    myCircularQueue.Rear();     // return 4
    return 0;
}