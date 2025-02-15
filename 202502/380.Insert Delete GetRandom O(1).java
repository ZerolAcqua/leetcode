/*
 * @lc app=leetcode id=380 lang=java
 * @lcpr version=20004
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class RandomizedSet {

    private List<Integer> nums;
    private HashMap<Integer, Integer> val2idx;
    private Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        val2idx = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (val2idx.containsKey(val)) {
            return false;
        }
        val2idx.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!val2idx.containsKey(val)) {
            return false;
        }

        int idx = val2idx.get(val);
        int newIdx = nums.size() - 1;
        int element = nums.get(newIdx);

        Collections.swap(nums, idx, newIdx);
        val2idx.put(element, idx);

        val2idx.remove(val);
        nums.remove(newIdx);
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
// @lc code=end

