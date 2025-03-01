/*
 * @lc app=leetcode id=394 lang=java
 * @lcpr version=30005
 *
 * [394] Decode String
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    HashMap<Integer, Integer> rightIdx = new HashMap<>();

    public String decodeString(String s) {
        Stack<Integer> stk = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '[') {
                stk.push(i);
            } else if (c == ']') {
                rightIdx.put(stk.pop(), i);
            }
        }

        return _decodeString(s, 0, s.length() - 1);
    }

    private String _decodeString(String s, int start, int end) {
        int repeat = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            // normal string
            if (Character.isLetter(c)) {
                sb.append(c);
            } // parse repeat time
            else if (Character.isDigit(c)) {
                repeat = repeat * 10 + (c - '0');
            } // parse repeat string
            else {
                int left = i;
                int right = rightIdx.get(left);
                sb.append(_decodeString(s, left + 1, right - 1).repeat(repeat));
                repeat = 0;
                i = right;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

/*
// @lcpr case=start
// "3[a]2[bc]"\n
// @lcpr case=end

// @lcpr case=start
// "3[a2[c]]"\n
// @lcpr case=end

// @lcpr case=start
// "2[abc]3[cd]ef"\n
// @lcpr case=end

 */
