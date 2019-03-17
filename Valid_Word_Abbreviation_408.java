/**
* a very facebook question 
* // bug :  here if ==, ch still a char missed
* // bug missed the case when in the end num not zero !!
*/


class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int ptr = 0, i = 0, num = 0;
        while (i < abbr.length()) {
            if (ptr >= word.length()) return false;
            
            char ch = abbr.charAt(i);
            i++;
            if (Character.isDigit(ch)) {
                if (num == 0 && (ch-'0')==0) return false;
                num = num*10 + (ch-'0');
            } else {
                if (num != 0) {
                    ptr += num;
                }
                num = 0;
                // if (ptr == word.length() && i == abbr.length()) return true; // this is bug, here if ==, means false too
                if (ptr >= word.length() || word.charAt(ptr) != ch)  // bug :  here if ==, ch still a char missed
                    return false;
                ptr++;
            }
            
        }
        // return ptr == word.length(); // bug missed the case when in the end num not zero !!
        return ptr+num == word.length();  // missed the case "hi" "2i" when ptr reach the end first <- not a problem anymore 
                                                                                    in current version.
    }
}
