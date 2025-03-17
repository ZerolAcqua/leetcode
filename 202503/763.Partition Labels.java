/*
 * @lc app=leetcode id=763 lang=java
 * @lcpr version=30005
 *
 * [763] Partition Labels
 */


// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();

        int [] lastIdx = new int[26];
        int farest = 0;

        for(int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            lastIdx[c - 'a'] = i;
        }

        
        int length = 0;
        for(int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            length++;
            farest = Math.max(farest, lastIdx[c - 'a']);
            if(farest == i) {
                res.add(length);
                length=0;
            }
        }

        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "ababcbacadefegdehijhklij"\n
// @lcpr case=end

// @lcpr case=start
// "eccbbbbdec"\n
// @lcpr case=end

 */

