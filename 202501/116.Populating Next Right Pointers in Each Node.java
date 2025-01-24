/*
 * @lc app=leetcode id=116 lang=java
 * @lcpr version=20004
 *
 * [116] Populating Next Right Pointers in Each Node
 */


// @lcpr-template-start


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

// @lc code=start
class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
 
        root.left.next = root.right;

        if (root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);

        return root;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5,6,7]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

