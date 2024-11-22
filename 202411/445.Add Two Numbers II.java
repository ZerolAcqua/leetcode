/*
 * @lc app=leetcode id=445 lang=java
 * @lcpr version=20003
 *
 * [445] Add Two Numbers II
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reserveList(l1);
        l2 = reserveList(l2);

        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (carry != 0 || p1 != null && p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            p.next = new ListNode(carry % 10);
            p = p.next;
            carry /= 10;

        }
        if (p1 != null) {
            p.next = p1;
        } else {
            p.next = p2;
        }

        return reserveList(dummy.next);
    }

    ListNode reserveList(ListNode l) {
        ListNode p1 = null;
        ListNode p = l;
        ListNode temp = null;
        while (p != null) {
            temp = p.next;
            p.next = p1;
            p1 = p;
            p = temp;
        }
        return p1;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [7,2,4,3]\n[5,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [2,4,3]\n[5,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n[0]\n
// @lcpr case=end

 */
