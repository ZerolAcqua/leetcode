/*
 * @lc app=leetcode id=155 lang=java
 * @lcpr version=30005
 *
 * [155] Min Stack
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class MinStack {

    Stack<Integer> stk;
    Stack<Integer> minStk;

    public MinStack() {
        stk = new Stack<>();
        minStk = new Stack<>();
    }

    public void push(int val) {
        stk.push(val);
        if(minStk.isEmpty()) {
            minStk.push(val);
        } else {
            if(val < minStk.peek()) {
                minStk.push(val);
            } else {
                minStk.push(minStk.peek());
            }
        }
    }

    public void pop() {
        minStk.pop();
        stk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end



