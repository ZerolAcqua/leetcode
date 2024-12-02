/*
 * @lc app=leetcode id=25 lang=java
 * @lcpr version=20003
 *
 * [25] Reverse Nodes in k-Group
 */

// @lcpr-template-start
// @lc code=start
class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    private ListNode successor = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode a = head;
        ListNode b = head;

        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reverseN(a, k);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public ListNode reverseN(ListNode head, int N) {
        if (N == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, N - 1);
        head.next.next = head;
        head.next = successor;
        return last;
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
