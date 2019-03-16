/**
* 电面题
*/

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        int[] count = new int[128];
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        for (char ch: cht) {count[ch]++;}
        int required = cht.length;
        int opti = 0, len = Integer.MAX_VALUE;
        for (int i = 0, j = 0; j < m; j++) {
            if (count[chs[j]] > 0) required--;
            count[chs[j]]--;
            while (required == 0) {
                if (len > j - i + 1) {
                    opti = i;
                    len = j - i + 1;
                }
                count[chs[i]]++;
                if (count[chs[i]] > 0) required++;
                i++;
            }
        }  
        return (len == Integer.MAX_VALUE) ? "" : new String(chs, opti, len);
    }
}
