/*
 * @lc app=leetcode id=131 lang=java
 * @lcpr version=30005
 *
 * [131] Palindrome Partitioning
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    List<List<String>> res = new LinkedList<>();
    List<String> path = new LinkedList<>();
    int[][] memo; // "0"-unknown "1"-true "-1"-false
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        memo = new int[n][n];

        for (int i = 0; i < n; i++) {
            memo[i][i] = 1;
        }

        backTracking(s, 0);

        return res;
    }

    private void backTracking(String s, int start) {
        if (start >= n) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i < n; i++) {
            if (isPalindrome(s, start, i)) {
                path.addLast(s.substring(start, i + 1));
                backTracking(s, i + 1);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (memo[start][end] != 0) {
            return memo[start][end] == 1;
        }

        int left = start;
        int right = end;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                memo[start][end] = -1;
                return false;
            }
            left++;
            right--;
        }

        memo[start][end] = 1;
        return true;
    }
}
// @lc code=end

/*
// @lcpr case=start
// "aab"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n
// @lcpr case=end

 */
