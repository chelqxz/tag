/**
* hashmap (character, rightmost index)
* sliding window: left right
*   stoping : right < n
*   update: ch : rightmost char, update the map for the new info
*   get the one with the min value in the map (if use linkedhashmap, simply the earliest added one)
*   delete that entry and update left pointer
*/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n == 0 || k == 0) return 0;
        int left = 0;
        int right = 0;
        // (character, rightmost index)
        LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(); 

        int ans = 1;

        while (right < n) {
          Character character = s.charAt(right);
          // if character is already in the hashmap -
          // delete it, so that after insert it becomes
          // the rightmost element in the hashmap
          if (hashmap.containsKey(character))
              hashmap.remove(character);
          hashmap.put(character, right++);

          // slidewindow contains k + 1 characters
          if (hashmap.size() == k + 1) {
            // delete the leftmost character
            Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
            hashmap.remove(leftmost.getKey());
            // move left pointer of the slidewindow
            left = leftmost.getValue() + 1; // update the rightmost i can get without the char 
          }

          ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
