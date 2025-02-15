/*
 * @lc app=leetcode id=460 lang=java
 * @lcpr version=20004
 *
 * [460] LFU Cache
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class LFUCache {

    HashMap<Integer, Integer> key2val;
    HashMap<Integer, Integer> key2freq;
    HashMap<Integer, LinkedHashSet<Integer>> freq2keys;

    int minFreq;
    int cap;

    public LFUCache(int capacity) {
        key2val = new HashMap<>();
        key2freq = new HashMap<>();
        freq2keys = new HashMap<>();
        cap = capacity;
    }

    public int get(int key) {
        if (!key2val.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);
        return key2val.get(key);
    }

    public void put(int key, int value) {
        if (key2val.containsKey(key)) {
            key2val.put(key, value);
            increaseFreq(key);
            return;
        }

        if (key2val.size() == cap) {
            removeUnfreq();
        }

        addNew(key, value);
    }

    void increaseFreq(int key) {
        int freq = key2freq.get(key);
        key2freq.put(key, freq + 1);

        freq2keys.get(freq).remove(key);
        freq2keys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freq2keys.get(freq + 1).add(key);

        if (freq2keys.get(freq).isEmpty()) {
            freq2keys.remove(freq);
            if (freq == minFreq) {
                minFreq++;
            }
        }
    }

    // 不需要修改 minFreq，新增的内容 freq 会将其设为 1 的
    void removeUnfreq() {
        LinkedHashSet<Integer> keyList = freq2keys.get(minFreq);
        int deletedKey = keyList.iterator().next();

        keyList.remove(deletedKey);
        key2val.remove(deletedKey);
        key2freq.remove(deletedKey);

        if (keyList.isEmpty()) {
            freq2keys.remove(minFreq);
        }
    }

    void addNew(int key, int val) {
        key2val.put(key, val);
        key2freq.put(key, 1);
        freq2keys.putIfAbsent(1, new LinkedHashSet<Integer>());
        freq2keys.get(1).add(key);

        minFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end

