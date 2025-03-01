/*
 * @lc app=leetcode id=138 lang=java
 * @lcpr version=30005
 *
 * [138] Copy List with Random Pointer
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end

class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// @lc code=start
class Solution {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node dummy = new Node(0);
        Node tgt = dummy;

        Node src = head;
        while (src != null) {
            Node curNode = new Node(src.val);
            tgt.next = curNode;
            map.put(src, curNode);
            src = src.next;
            tgt = tgt.next;
        }

        src = head;
        tgt = dummy.next;

        while (src != null) {
            if (src.random != null) {
                tgt.random = map.get(src.random);
            }

            src = src.next;
            tgt = tgt.next;
        }

        return dummy.next;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [[7,null],[13,0],[11,4],[10,2],[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1],[2,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[3,null],[3,0],[3,null]]\n
// @lcpr case=end

 */
