/** 
* bug. 1. has negative number so the way to move ptr does not work
*/
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) 
            sum[i+1] = sum[i] + (long) A[i];
        int ans = n+1;
        Deque<Integer> deque = new LinkedList<>();
        for (int y = 0; y < sum.length; y++) { 
            // bug : start with  y = 1, should be 0, example for the case [1] , 1
            while (!deque.isEmpty() && sum[deque.peekLast()] >= sum[y]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && sum[deque.getFirst()] <= sum[y] - K) {
                ans = Math.min(ans, y-deque.removeFirst());
            }
            deque.offerLast(y);
        }
        return ans == n+1 ? -1 : ans;
    }
}

/**
[84,-37,32,40,95]
167 
:5
:4
*/
