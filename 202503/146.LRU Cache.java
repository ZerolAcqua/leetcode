/*
 * @lc app=leetcode id=146 lang=java
 * @lcpr version=30103
 *
 * [146] LRU Cache
 */

 import java.util.LinkedHashMap;

 // @lc code=start
 class LRUCache {
     int cap;
     LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
 
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
             makeRecent(key);
             cache.put(key, value);
             return;
         }
 
         if (cache.size() == cap) {
             int oldestKey = cache.keySet().iterator().next();
             cache.remove(oldestKey);
         }
 
         cache.put(key, value);
     }
 
     private void makeRecent(int key) {
         int val = cache.get(key);
         cache.remove(key);
         cache.put(key, val);
     }
 }
 
 /**
  * Your LRUCache object will be instantiated and called as such:
  * LRUCache obj = new LRUCache(capacity);
  * int param_1 = obj.get(key);
  * obj.put(key,value);
  */
 
 /**
  * Your LRUCache object will be instantiated and called as such:
  * LRUCache obj = new LRUCache(capacity);
  * int param_1 = obj.get(key);
  * obj.put(key,value);
  */
 // @lc code=end
 
 
 
 