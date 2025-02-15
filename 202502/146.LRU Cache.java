/*
 * @lc app=leetcode id=146 lang=java
 * @lcpr version=20004
 *
 * [146] LRU Cache
 */

// @lcpr-template-start
import java.util.LinkedHashMap;
// @lcpr-template-end
// @lc code=start

class LRUCache {

    int cap;

    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecent(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecent(key);
            return;
        }

        if (cache.size() == cap) {
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, value);
    }

    void makeRecent(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end

