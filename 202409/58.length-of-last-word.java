/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        // return s.trim().length() - s.trim().lastIndexOf(" ") - 1; // wtf?
        int len = s.length();
        // iterate from the end of the string
        int end = len - 1;
        int start = 0;
        // find the first non-space character from the end
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        // find the first space character from the end
        start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}
// @lc code=end

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
    }
}