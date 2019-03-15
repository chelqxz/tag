/**
* top down dp (memorization) 
* time complexity: O(n^3) because substring(O(n)) 
* bug: memo[0] =  true; base case missed
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()+1];
        memo[0] = true;
        
        return helper(s, s.length(), dict, memo);
    }
    
    public boolean helper(String s, int j, HashSet<String> dict, Boolean[] memo) {
        if (memo[j] != null) return memo[j];
        for (int i = 0; i < j; i++) {
            if (dict.contains(s.substring(i,j)) && helper(s, i, dict, memo)) {
                memo[j] = true;
                return true;
            }
        }
        memo[j] = false;
        return memo[j];
    }
}


/**
* bottom up dp 
* time complexity: O(n^3) because substring(O(n)) 
* difficulty: for (int j = 0; j < i; j++) : go through a example in head to decide
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] memo = new boolean[s.length()+1];
        memo[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dict.contains(s.substring(j,i)) && memo[j]) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }
}
