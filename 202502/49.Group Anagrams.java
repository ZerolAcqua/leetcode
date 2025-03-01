/*
 * @lc app=leetcode id=49 lang=java
 * @lcpr version=30005
 *
 * [49] Group Anagrams
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();

        int[] count = new int[26];

        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    sb.append(i + 'a');
                    sb.append(Integer.toString(count[i]));
                    count[i] = 0;
                }
            }

            String key = sb.toString();
            hash.putIfAbsent(key, new LinkedList<>());
            hash.get(key).add(str);
        }

        List<List<String>> res = new LinkedList<>();

        for (List<String> list : hash.values()) {
            res.add(list);
        }

        return res;
    }
}
// @lc code=end

/*
// @lcpr case=start
// ["eat","tea","tan","ate","nat","bat"]\n
// @lcpr case=end

// @lcpr case=start
// [""]\n
// @lcpr case=end

// @lcpr case=start
// ["a"]\n
// @lcpr case=end

 */
