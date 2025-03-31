/*
 * @lc app=leetcode id=2 lang=java
 * @lcpr version=30103
 *
 * [2] Add Two Numbers
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        boolean bit = false;
        while (l1 != null || l2 != null || bit) {
            int nextDigit = 0;
            if (l1 != null) {
                nextDigit += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                nextDigit += l2.val;
                l2 = l2.next;
            }
            if (bit) {
                nextDigit += 1;
                bit = false;
            }

            if (nextDigit / 10 > 0) {
                bit = true;
                nextDigit %= 10;
            }

            cur.next = new ListNode(nextDigit);
            cur = cur.next;
        }

        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,4,3]\n[5,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n[0]\n
// @lcpr case=end

// @lcpr case=start
// [9,9,9,9,9,9,9]\n[9,9,9,9]\n
// @lcpr case=end

 */

