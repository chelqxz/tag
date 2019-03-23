// stack store number and sign , deal with * ans / in first 
// round and second round  + and - <- initital thought

class Solution {
    public int calculate(String s) {
        if (s==null || s.length() ==0) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0; // initializatino
        char sign = '+';
        for (int i = 0; i < len; i++) {
            // if (s.charAt(i) == ' ') continue; // " 3/2 " a space in the end
            if (Character.isDigit(s.charAt(i))) {
                num = num*10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i==len-1) { // deal with sign or end of expression
            // edge case i == len-1 do not miss the end
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i); // update sign 
                num = 0; // update num
            }
        }

        int re = 0;
        for(int i:stack){
            re += i; // leave all with sign +
        }
        return re;
    }
}
