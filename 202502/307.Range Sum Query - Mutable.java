/*
 * @lc app=leetcode id=307 lang=java
 * @lcpr version=20004
 *
 * [307] Range Sum Query - Mutable
 */

// @lcpr-template-start
import java.util.function.*;
// @lcpr-template-end
// @lc code=start

class NumArray {

    int[] tree;
    int n;
    private final BinaryOperator<Integer> merger = (a, b) -> a + b;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];

        build(nums, 0, 0, n - 1);
    }

    public void update(int index, int val) {
        update(index, val, 0, 0, n - 1);
    }

    private void update(int index, int val, int rootIdx, int l, int r) {
        if (l == r) {
            tree[rootIdx] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        int leftNodeIdx = leftIdx(rootIdx);
        int rightNodeIdx = rightIdx(rootIdx);

        if (index <= mid) {
            update(index, val, leftNodeIdx, l, mid);
        } else {
            update(index, val, rightNodeIdx, mid + 1, r);
        }

        tree[rootIdx] = merger.apply(tree[leftNodeIdx], tree[rightNodeIdx]);
    }

    public int sumRange(int left, int right) {
        return query(left, right, 0, 0, n - 1);
    }

    private int query(int left, int right, int rootIdx, int l, int r) {
        if (left == l && right == r) {
            return tree[rootIdx];
        }

        int mid = l + (r - l) / 2;

        int leftNodeIdx = leftIdx(rootIdx);
        int rightNodeIdx = rightIdx(rootIdx);

        if (right <= mid) {
            return query(left, right, leftNodeIdx, l, mid);
        } else if (left > mid) {
            return query(left, right, rightNodeIdx, mid + 1, r);
        } else {
            return merger.apply(
                    query(left, mid, leftNodeIdx, l, mid),
                    query(mid + 1, right, rightNodeIdx, mid + 1, r));
        }

    }

    private void build(int[] nums, int rootIdx, int l, int r) {
        if (l == r) {
            tree[rootIdx] = nums[l];
            return;
        }

        int mid = l + (r - l) / 2;

        int leftNodeIdx = leftIdx(rootIdx);
        int rightNodeIdx = rightIdx(rootIdx);

        build(nums, leftNodeIdx, l, mid);
        build(nums, rightNodeIdx, mid + 1, r);

        tree[rootIdx] = merger.apply(tree[leftNodeIdx], tree[rightNodeIdx]);
    }

    private int leftIdx(int rootIdx) {
        return 2 * rootIdx + 1;
    }

    private int rightIdx(int rootIdx) {
        return 2 * rootIdx + 2;
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(index,val); int param_2 =
 * obj.sumRange(left,right);
 */
// @lc code=end

