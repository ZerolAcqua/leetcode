/*
 * @lc app=leetcode id=206 lang=java
 * @lcpr version=20003
 *
 * [206] Reverse Linked List
 */

// @lcpr-template-start
// @lc code=start

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public ListNode reverseList(ListNode head) {
        // base case 
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return last;

    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */
