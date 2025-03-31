/*
 * @lc app=leetcode id=23 lang=java
 * @lcpr version=30103
 *
 * [23] Merge k Sorted Lists
 */

import java.util.PriorityQueue;

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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        int n = lists.length;
        int count = 0;

        ListNode dummy = new ListNode();
        ListNode p = dummy;

        for (int i = 0; i < n; i++) {
            ListNode list = lists[i];
            if (list != null) {
                pq.offer(list);
                lists[i] = list.next;
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;

            if (node.next != null) {
                pq.offer(node.next);
            }
            p = p.next;
        }

        return dummy.next;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [[1,4,5],[1,3,4],[2,6]]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [[]]\n
// @lcpr case=end

 */
