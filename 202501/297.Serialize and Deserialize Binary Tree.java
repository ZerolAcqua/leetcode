/*
 * @lc app=leetcode id=297 lang=java
 * @lcpr version=20004
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lcpr-template-start
import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// @lc code=start
class Codec {

    String sep = ",";
    String nil = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        _serialize(root, sb);
        return sb.toString();
    }

    void _serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(nil).append(sep);
            return;
        }

        sb.append(root.val).append(sep);
        _serialize(root.left, sb);
        _serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(sep)) {
            nodes.addLast(s);
        }

        return _deserialize(nodes);
    }

    TreeNode _deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String first = nodes.removeFirst();

        if (first.equals(nil)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = _deserialize(nodes);
        root.right = _deserialize(nodes);

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
/*
// @lcpr case=start
// [1,2,3,null,null,4,5]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */
