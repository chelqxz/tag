/** 
* 和我的电面题很相似的一道题， 最优解的想法知道了， 但是还是写了一堆bug！
* 而且有好多种方法，有些是很慢的， 但是也可以过一遍，到时候可以循序渐进的提出最优解
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] counts = new int[26];
        for (char ch: s1.toCharArray()) {
            counts[(ch-'a')]++;
        }
        int required = s1.length();
        int i = 0, j = 0;
        while (j-i < s1.length()) { // bug: ! very not easy found bug here should be j-i
            int ch = s2.charAt(j) - 'a';
            if (counts[ch] > 0) { // bug: counts[j] wrong! j is the index of the character in the string
                required--;
            }
            counts[ch]--; // bug: this should absolute out the if statement 
            j++;
        }
        
        while (j < s2.length()) {
            if (required == 0) return true;
            int ch = s2.charAt(i++) - 'a';
            counts[ch] ++;
            if (counts[ch] > 0) {
                required++;
            }
            // i++; // bug : missed this !
            ch = s2.charAt(j++) - 'a';
            if (counts[ch] > 0) {
                required--;
            }
            counts[ch]--;
        }
        if (required == 0) return true;
        return false;
    }
}
