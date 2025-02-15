/*
 * @lc app=leetcode id=1373 lang=java
 * @lcpr version=20004
 *
 * [1373] Maximum Sum BST in Binary Tree
 */


// @lcpr-template-start
// @lcpr-template-end

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// @lc code=start
class Solution {

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        findMaxMinSum(root);
        return maxSum;
    }


    int [] findMaxMinSum(TreeNode root) {
        if(root == null) {
            return new int[]{
                1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0
            };
        }

        int [] left = findMaxMinSum(root.left);
        int [] right = findMaxMinSum(root.right);

        // {1/0(是否 BST), max, min, sum}
        int [] res = new int[4];
        if(left[0]==0 || right[0]==0){
            res[0] = 0;
            return res;
        }

        if(left[1]>= root.val || right[2] <= root.val){
            res[0] = 0;
            return res;
        }

        int min = Math.min(left[2], root.val);
        int max = Math.max(right[1], root.val); 
        int sum = left[3] + right[3] + root.val;
        maxSum = Math.max(maxSum, sum);

        res[0] = 1;
        res[1] = max;
        res[2] = min;
        res[3] = sum;

        return res;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]\n
// @lcpr case=end

// @lcpr case=start
// [4,3,null,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [-4,-2,-5]\n
// @lcpr case=end

 */

