/*
 * @lc app=leetcode id=842 lang=java
 * @lcpr version=20003
 *
 * [842] Split Array into Fibonacci Sequence
 */


import java.util.LinkedList;
import java.util.List;

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public List<Integer> splitIntoFibonacci(String num) {

        int n = num.length();
        for (int i = 1; i <= n; i++) {
            String first = num.substring(0, i);
            for (int j = i + 1; j <= n; j++) {
                String second = num.substring(i, j);
                LinkedList<Integer> res = isValid(num, first, second);
                if (res != null)
                    return res;
            }
        }
        return new LinkedList<>();

    }

    LinkedList<Integer> isValid(String num, String first, String second) {
        if (first.startsWith("0") && first.length() > 1
                || second.startsWith("0") && second.length() > 1) {
            return null;
        }

        if (first.length() > 10 || Long.parseLong(first) > Integer.MAX_VALUE ||
                second.length() > 10 || Long.parseLong(second) > Integer.MAX_VALUE) {
            return null;
        }

        String numStr = strAdd(first, second);
        String nextStr = num.substring(first.length() + second.length());

        if (!nextStr.startsWith(numStr)) {
            return null;
        }
        if (numStr.length() > 10 || Long.parseLong(numStr) > Integer.MAX_VALUE) {
            return null;
        }

        if (nextStr.equals(numStr)) {
            LinkedList<Integer> res = new  LinkedList<>();
            res.addLast(Integer.valueOf(first));
            res.addLast(Integer.valueOf(second));
            res.addLast(Integer.valueOf(numStr));
            return res;
        }

        LinkedList<Integer> subProblem =  isValid(num.substring(first.length()), second, numStr);
        if(subProblem == null){
            return null;
        }else{
            subProblem.addFirst(Integer.valueOf(first));
            return subProblem;
        }
   
    }

    String strAdd(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        StringBuilder res = new StringBuilder();

        int m = a.length();
        int n = b.length();

        int carry = 0;
        int i = 0;

        while (i < Math.max(m, n) || carry != 0) {
            carry += i < m ? (a.charAt(i) - '0') : 0;
            carry += i < n ? (b.charAt(i) - '0') : 0;
            res.append(carry % 10);
            carry /= 10;
            i++;
        }
        return res.reverse().toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// "1101111"\n
// @lcpr case=end

// @lcpr case=start
// "112358130"\n
// @lcpr case=end

// @lcpr case=start
// "0123"\n
// @lcpr case=end

 */

