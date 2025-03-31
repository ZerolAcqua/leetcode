/*
 * @lc app=leetcode id=25 lang=java
 * @lcpr version=30103
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode segEnd = head;
        for (int i = 0; i < k - 1; i++) {
            segEnd = segEnd.next;
            if (segEnd == null) {
                break;
            }
        }

        ListNode res = head;
        if (segEnd != null) {
            ListNode segStart = segEnd.next;
            segEnd.next = null;
            res = reverseList(head);
            head.next = reverseKGroup(segStart, k); 
        } 

        return res;

    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n3\n
// @lcpr case=end

 */

