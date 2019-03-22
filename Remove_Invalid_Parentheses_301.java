class Solution {
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    // index, last_delete
    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        // stack counter ( ++  ) --
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++; // ( // use char[] so can switch the order
            if (s.charAt(i) == par[1]) stack--; // )
            if (stack >= 0) continue; 
            // stack < 0 
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) // delete the first appeared one
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par); // j start of deletion
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }

}

class Solution {
    
    HashSet<String> res;
    int minlevel = Integer.MAX_VALUE;
    
    public List<String> removeInvalidParentheses(String s) {
        res = new HashSet<>(); // avoid duplicate
        helper(s, new StringBuilder(), 0, 0, 0, 0);
        return new ArrayList<>(res);
    }
    
    private void helper(String s, StringBuilder sb, int index, int left, int right, int depth) {
        // base case
        if (left < right) return; // extra pruning 
        if (depth > minlevel) return;
        if (index == s.length()) { // end scenario
            if (left != right) return;
            if (depth < minlevel) { // deleted characters = depth
                res.clear(); 
                res.add(sb.toString());
                minlevel = depth;
            } else if (depth == minlevel) {
                res.add(sb.toString());
            } // if depth > minlevel, no need to concern
            return;
        }
        
        char ch = s.charAt(index); // index valid 
        
        // not bracket character, add to sb and move on
        if (ch != '(' && ch != ')') {
            sb.append(ch);
            helper(s, sb, index+1, left, right, depth);
            sb.deleteCharAt(sb.length()-1); // backtrack
            // return; // missed this, 
        } else {
            helper(s, sb, index+1, left, right, depth+1); // the case ignored current char
            sb.append(ch);
            if (ch == '(')
                helper(s, sb, index+1, left+1, right, depth);
            else 
                helper(s, sb, index+1, left, right+1, depth);
            sb.deleteCharAt(sb.length()-1); // backtrack
        }
    }
    

}
