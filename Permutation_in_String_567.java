/** 
* 和我的电面题很相似的一道题， 最优解的想法知道了， 但是还是写了一堆bug！
* 而且有好多种方法，有些是很慢的， 但是也可以过一遍，到时候可以循序渐进的提出最优解
* 其他解法的关键是会reason about complexity
* 
* method 0: find all permutation and check if one is substring, O (n!) time O(n^2) : the depth of the recursino tree is n, n is the length of s1, every node of the recursion tree contains a string of max? length n
* method 1: same permutaion: sorted(x) = sorted(y), sort s1 and all substrings of s2 adn then compare. O (l1log(l1) + (l2-l1)l1log(l1)) ? time O(l1) space, l2-l1 is the number of substrings in s2 with length same as l1
* method 2: frequency occurrence to check if permutatinon (hashmap). need to check for every possible substring of s2. O(l1 + 26 * l1 * (l2-l1)) time and O(1) space because hashmap contains at most 26 key value pairs. here is also an implementation of using hashmap to avoid sorting
* method 3: use simple array data structure to store the frequencies. same complexity as the last one but faster because of array
* method 4: sliding window: avoid create an array or hashmap for frequencies for each substring. update one as window slides
* method 5:trickL i think it sould be what i am using? (l1 + (l2-l1)) = l2, constant space 
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
