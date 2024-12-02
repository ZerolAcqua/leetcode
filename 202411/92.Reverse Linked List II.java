/*
 * @lc app=leetcode id=92 lang=java
 * @lcpr version=20003
 *
 * [92] Reverse Linked List II
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if (left == 1) {
            return reverseN(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
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
// [1,2,3,4,5]\n2\n4\n
// @lcpr case=end

// @lcpr case=start
// [5]\n1\n1\n
// @lcpr case=end

 */
