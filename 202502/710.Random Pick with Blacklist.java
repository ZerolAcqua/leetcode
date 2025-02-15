/*
 * @lc app=leetcode id=710 lang=java
 * @lcpr version=20004
 *
 * [710] Random Pick with Blacklist
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    HashMap<Integer, Integer> map;
    Random rand;
    int sz;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        rand = new Random();
        HashSet<Integer> set = new HashSet<>();
        for (int i : blacklist) {
            set.add(i);
        }

        sz = n - blacklist.length;
        int last = n - 1;

        for (int i : blacklist) {
            while (set.contains(last)) {
                last--;
            }

            if (i > sz - 1) {
                continue;
            }
            map.put(i, last);
            last--;
        }
    }

    public int pick() {
        int idx = rand.nextInt(sz);
        if (map.containsKey(idx)) {
            return map.get(idx);
        } else {
            return idx;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(n, blacklist); int param_1 = obj.pick();
 */
// @lc code=end

