/*
 * @lc app=leetcode id=341 lang=java
 * @lcpr version=20004
 *
 * [341] Flatten Nested List Iterator
 */

// @lcpr-template-start
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
// @lcpr-template-end

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

// @lc code=start
class NestedIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty()) {
            if (list.getFirst().isInteger()) {
                return true;
            } else {
                List<NestedInteger> firstList = list.removeFirst().getList();
                for (int i = firstList.size() - 1; i >= 0; i--) {
                    list.addFirst(firstList.get(i));
                }
            }

        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */
// @lc code=end
/*
// @lcpr case=start
// [[1,1],2,[1,1]]\n
// @lcpr case=end

// @lcpr case=start
// [1,[4,[6]]]\n
// @lcpr case=end

 */
