/*
 * @lc app=leetcode id=792 lang=java
 * @lcpr version=20004
 *
 * [792] Number of Matching Subsequences
 */

// @lcpr-template-start
import java.util.*;
// @lcpr-template-end
// @lc code=start

class Solution {

    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<Integer>[] charToIndex = new ArrayList[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charToIndex[c - 'a'] == null) {
                charToIndex[c - 'a'] = new ArrayList<>();
            }
            charToIndex[c - 'a'].add(i);

        }

        int res = 0;

        for (String word : words) {
            int idx = 0;

            for (char c : word.toCharArray()) {
                if (charToIndex[c - 'a'] == null) {
                    idx = -1;
                    break;
                }

                if (charToIndex[c - 'a'].get(charToIndex[c - 'a'].size() - 1) < idx) {
                    idx = -1;
                    break;
                }
                int pos = getLeftBound(charToIndex[c - 'a'], idx);
                // 使用内置函数
                // int pos = Collections.binarySearch(charToIndex[c - 'a'], idx);

                // if (pos < 0) {
                //     pos = Math.abs(pos) - 1;
                // }

                idx = charToIndex[c - 'a'].get(pos) + 1;
            }
            if (idx != -1) {
                res++;
            }
        }

        return res;
    }

    int getLeftBound(ArrayList<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }
}
// @lc code=end

/*
// @lcpr case=start
// "abcde"\n["a","bb","acd","ace"]\n
// @lcpr case=end

// @lcpr case=start
// "dsahjpjauf"\n["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]\n
// @lcpr case=end

 */
