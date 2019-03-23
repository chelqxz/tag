// n
class Solution {
    public String customSortString(String S, String T) {
        // count[char] = the number of occurrences of 'char' in T.
        // This is offset so that count[0] = occurrences of 'a', etc.
        // 'count' represents the current state of characters
        // (with multiplicity) we need to write to our answer.
        int[] count = new int[26];
        for (char c: T.toCharArray())
            count[c - 'a']++;

        // ans will be our final answer.  We use StringBuilder to join
        // the answer so that we more efficiently calculate a
        // concatenation of strings.
        StringBuilder ans = new StringBuilder();

        // Write all characters that occur in S, in the order of S.
        for (char c: S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);
            // Setting count[char] to zero to denote that we do
            // not need to write 'char' into our answer anymore.
            count[c - 'a'] = 0;
        }

        // Write all remaining characters that don't occur in S.
        // That information is specified by 'count'.
        for (char c = 'a'; c <= 'z'; ++c)
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);

        return ans.toString();
    }
}




//nlogn
class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        
        char[] cs = T.toCharArray();
        Character[] chs = new Character[cs.length];
        for (int i = 0; i< cs.length; i++) {
            chs[i] = cs[i];
        }
        Arrays.sort(chs, new Comparator<Character>() {
            public int compare(Character ch1, Character ch2) {
                if (map.containsKey(ch1) && map.containsKey(ch2)) {
                    return map.get(ch1) - map.get(ch2);
                }
                if (map.containsKey(ch1))  // ch1 before
                    return -1;
                if (map.containsKey(ch2)) // ch2 before 
                    return 1;
                return 0; // （不能这样以为关系混乱，a < b in order in S）
                // 不对，可以！ 但是不是最优解 bug1， 是因为只有在乎ch1
                // ans ch2 both exists in the map时候的顺序
            }
        });
        StringBuilder sb = new StringBuilder();
        
        for (Character ch : chs) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
