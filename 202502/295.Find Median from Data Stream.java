/*
 * @lc app=leetcode id=295 lang=java
 * @lcpr version=20004
 *
 * [295] Find Median from Data Stream
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>(
                (a, b) -> {
                    return b - a;
                });
    }

    public void addNum(int num) {
        if (small.isEmpty() || num < small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }

        if (small.size() - large.size() > 1) {
            large.offer(small.poll());
        } else if (small.size() - large.size() < -1) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (small.size() < large.size()) {
            return large.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
// @lc code=end

