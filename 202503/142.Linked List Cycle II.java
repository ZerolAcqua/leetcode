/*
 * @lc app=leetcode id=142 lang=java
 * @lcpr version=30103
 *
 * [142] Linked List Cycle II
 */

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }

        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [3,2,0,-4]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [1]\n-1\n
// @lcpr case=end

 */
