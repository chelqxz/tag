/**
* bug: 1. {'a','e','i','o','u','A','E','I','O','U'}));  missed uppercase 
*/

class Solution {
    HashSet<Character> set = new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'})); 
    public String toGoatLatin(String S) {
        String[] words = S.split("\\s+"); // split by whitespace
        StringBuilder sb = new StringBuilder();
        StringBuilder sba = new StringBuilder();
        for (int i = 0; i< words.length; i++) {
            sba.append("a");
            String w = words[i];
            char ch = w.charAt(0);
            if (set.contains(ch)) {
                sb.append(w).append("ma");
            } else {
                sb.append(w.substring(1)).append(ch).append("ma");
            }
            
            sb.append(sba);
            if (i != words.length-1) sb.append(" ");
        }
        return sb.toString();
    }
}
