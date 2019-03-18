class Solution {
    public boolean isNumber(String s) {
        s = s.trim();// missed
        boolean eSeen = false;
        boolean dotSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                if (eSeen) 
                    numberAfterE = true;
                numberSeen = true;
            } else if (ch == '.') {
                if (dotSeen || eSeen)  // bug: &&
                    return false;
                dotSeen = true;
                
            } else if (ch == 'e') {
                if (eSeen || !numberSeen) return false; // !numberSeen
                eSeen = true;
                numberAfterE = false;
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i-1) != 'e')
                    return false;
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }
}
