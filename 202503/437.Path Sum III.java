/*
 * @lc app=leetcode id=437 lang=java
 * @lcpr version=30005
 *
 * [437] Path Sum III
 */

// @lcpr-template-start
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
// @lcpr-template-end

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
// @lc code=start

class Solution {

    int res = 0;
    HashMap<Long, Integer> count;
    long sum = 0;
    long targetSum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        count = new HashMap<>();
        count.put(0L, 1);
        this.targetSum = targetSum;

        tranverse(root);

        return res;
    }

    private void tranverse(TreeNode node) {
        if (node == null) {
            return;
        }

        sum += node.val;
        res += count.getOrDefault(sum - targetSum, 0);
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        tranverse(node.left);
        tranverse(node.right);

        count.put(sum, count.get(sum) - 1);
        sum -= node.val;

        return;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [10,5,-3,3,2,null,11,3,-2,null,1]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,4,8,11,null,13,4,7,2,null,null,5,1]\n22\n
// @lcpr case=end

 */
