/*
 * @lc app=leetcode id=347 lang=java
 * @lcpr version=30005
 *
 * [347] Top K Frequent Elements
 */

// @lcpr-template-start
import java.util.*;

// @lcpr-template-end
// @lc code=start
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(new Pair(key, map.get(key)));
            } else {
                if (pq.peek().freq < map.get(key)) {
                    pq.poll();
                    pq.offer(new Pair(key, map.get(key)));
                }
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().num;
        }

        return res;
    }

    class Pair implements Comparable<Pair> {

        int num, freq;

        public Pair(int i, int j) {
            num = i;
            freq = j;
        }

        @Override
        public int compareTo(Pair p) {
            return this.freq - p.freq;
        }
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,1,1,2,2,3]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

 */
