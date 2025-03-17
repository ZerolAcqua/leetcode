/*
 * @lc app=leetcode id=347 lang=java
 * @lcpr version=30100
 *
 * [347] Top K Frequent Elements
 */


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.putIfAbsent(num, 0);
            countMap.put(num, countMap.get(num) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (Iterator<Map.Entry<Integer, Integer>> it = countMap.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Integer, Integer> entry = it.next();
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().num;
        }

        return res;
    }
}

class Pair implements Comparable<Pair> {
    int num;
    int count;

    public Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Pair p2) {
        return p2.count - this.count;
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

