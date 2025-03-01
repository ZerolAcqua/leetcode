/*
 * @lc app=leetcode id=2259 lang=java
 * @lcpr version=30005
 *
 * [2259] Remove Digit From Number to Maximize Result
 */


// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {
    public String removeDigit(String number, char digit) {
        
        int lastIdx = -1;
        for(int i = 0; i < number.length() ; i++) {
            char c = number.charAt(i);

            if(c != digit) {
                continue;
            }
            
            lastIdx = i;
            if(i == number.length()-1)
                break;
            
            char next = number.charAt(i + 1);
            if(c<next)
                break;
        }
            
        if(lastIdx == -1) {
            return number;
        } else {
            StringBuilder sb = new StringBuilder(number);
            return sb.deleteCharAt(lastIdx).toString();
        }
    }
}
    
// @lc code=end



/*
// @lcpr case=start
// "123"\n"3"\n
// @lcpr case=end

// @lcpr case=start
// "1231"\n"1"\n
// @lcpr case=end

// @lcpr case=start
// "551"\n"5"\n
// @lcpr case=end

 */

