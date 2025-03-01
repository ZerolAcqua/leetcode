/*
 * @lc app=leetcode id=17 lang=java
 * @lcpr version=30005
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    ArrayList<String> res;
    HashMap<Character, String> map;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }

        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder sb = new StringBuilder();
        backTrack(sb, digits, 0);

        return res;
    }

    private void backTrack(StringBuilder sb, String digits, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char c = digits.charAt(idx);
        String str = map.get(c);
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTrack(sb, digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        return;
    }
}
// @lc code=end

/*
// @lcpr case=start
// "23"\n
// @lcpr case=end

// @lcpr case=start
// ""\n
// @lcpr case=end

// @lcpr case=start
// "2"\n
// @lcpr case=end

 */
