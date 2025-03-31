/*
 * @lc app=leetcode id=148 lang=java
 * @lcpr version=30103
 *
 * [148] Sort List
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// @lc code=start
class Solution {
    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode dummy = new ListNode(0, head);

        while (head != null) {
            length++;
            head = head.next;
        }

        ListNode lastSeg = null, nextSeg = null, breakSeg = null;
        ListNode l1 = null, l2 = null;
        int count = 0;

        for (int subLength = 1; subLength < length; subLength <<= 1) {
            lastSeg = dummy;
            nextSeg = dummy.next;
            while (nextSeg != null) {
                l1 = nextSeg;
                count = 0;
                while (count < subLength && nextSeg != null) {
                    breakSeg = nextSeg;
                    nextSeg = nextSeg.next;
                    count++;
                }
                breakSeg.next = null;

                l2 = nextSeg;

                count = 0;
                while (count < subLength && nextSeg != null) {
                    breakSeg = nextSeg;
                    nextSeg = nextSeg.next;
                    count++;
                }
                breakSeg.next = null;

                lastSeg.next = mergeList(l1, l2);

                while (lastSeg.next != null) {
                    lastSeg = lastSeg.next;
                }
            }
        }

        return dummy.next;

    }

    ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            cur.next = null;
        }

        if (l1 != null) {
            cur.next = l1;
            cur = cur.next;
        }

        if (l2 != null) {
            cur.next = l2;
            cur = cur.next;
        }

        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [-1,5,3,4,0]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

