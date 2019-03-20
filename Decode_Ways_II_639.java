/**
* 分情况:自己一个， 两个（**, *_, _*. __)
* bug: 1. use long !!
        2. missed * dp[i+2] !
        3.bug3 : 注意！！！(ch2 <= 6)  
        4. * can not be 0
        5. // diff for 1 and 2 for case __
*/

class Solution {
    public int numDecodings(String s) {
        int M = 1000000007;
        int n = s.length();
        long[] dp = new long[n+1]; // bug: use long !!
        dp[n] = 1;
        for (int i = n-1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch >='1' && ch <= '9') {
                dp[i] += dp[i+1] % M;
            }
            if (ch == '*') {
                dp[i] += dp[i+1] * 9 % M;
            }
            if (i+1 < s.length()) {
                char ch2 = s.charAt(i+1);
                if (ch == '*' && ch2 =='*') {
                    // 11 - 19 or 21 - 26
                    dp[i] += (9+6)*dp[i+2]% M; // bug1 : missed * dp[i+2] !
                } else if (ch == '*' && ch2 != '*') {
                    if (ch2 <= '6') dp[i] += 2*dp[i+2];//　bug3 : 注意！！！(ch2 <= 6)  
                    else dp[i] += 1*dp[i+2] % M;
                } else if (ch != '*' && ch2 == '*' && (ch == '2' || ch == '1')) {
                    if (ch == '2') {
                        // dp[i] += 7 * dp[i+2]; // ! bug2 : * can not be 0
                        dp[i] += 6 * dp[i+2] % M;
                    }
                    if (ch == '1') {
                        dp[i] += 9 * dp[i+2] % M;
                    }
                } else if (ch != '*' && ch2 != '*' && (ch == '2' || ch == '1')) {
                    // if (ch2 <= '6' && ch2 >= '0')  // diff for 1 and 2
                    if (ch == '1')
                        dp[i] += 1*dp[i+2] % M;
                    if (ch == '2' && ch2 <= '6' && ch2 >=0)
                        dp[i] += 1*dp[i+2] % M; 
                }
                dp[i] = dp[i] % M;
            }
            // System.out.println(i + " "+ dp[i]);
            
        }
        return (int)dp[0];
    }
}
