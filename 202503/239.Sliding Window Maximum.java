/*
 * @lc app=leetcode id=239 lang=java
 * @lcpr version=30100
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonoQueue mq = new MonoQueue();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            mq.add(nums[i]);
            if (mq.getSize() < k) {
                continue;
            }
            if (mq.getSize() > k) {
                mq.remove();
            }
            res[i - k + 1] = mq.getMax();
        }

        return res;
    }
}

class MonoQueue {
    Queue<Integer> q = new LinkedList<Integer>();
    Deque<Integer> maxQ = new LinkedList<Integer>();

    public void add(int val) {
        q.add(val);
        while (!maxQ.isEmpty() && maxQ.getLast() < val) {
            maxQ.removeLast();
        }
        maxQ.addLast(val);
    }

    public void remove() {
        int first = q.remove();
        if (first == maxQ.getFirst()) {
            maxQ.removeFirst();
        }
    }

    public int getMax() {
        return maxQ.getFirst();
    }

    public int getSize() {
        return q.size();
    }

}
// @lc code=end



/*
// @lcpr case=start
// [1,3,-1,-3,5,3,6,7]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

 */

