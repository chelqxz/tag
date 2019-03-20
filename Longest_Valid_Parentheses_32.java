/**
* method 1: 思维局限在 left ， right bracket的count <- 在试图想出stack的做法， 不对， 是approach 4 的做法！！！！！  // when right > left, reset, 第一直觉是对的！！！！ 应该用stack去帮助这种想法的！！！， 其实就是在用left 和right 去代替一个stack. 但是忽略了需要从右边往左搜一次， why？
* method 2: stack
* method 3: dp : subproblem!!!
*/


class Solution {
    public int longestValidParentheses(String s) {
        int len = 0; 
        Stack<Integer> stack = new Stack<>(); // keep track of the indexes for the last (
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    len = Math.max(len, i - stack.peek());
                }
            }
        }
        return len;
    }
}


//证明这个对可以想着用stack来证明
class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                len = Math.max(len, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '(' ) {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                len = Math.max(len, 2*left);
            } else if (right <= left) {
                left = right = 0;
            }
        }
        return len;
    }
}
