// 感觉有点像我google最好那个swap的题，反正就像， 或者找例子， 交流
// not bit manipulation (base 10)
// valid : overflow (non negative)

// thought of greedy but did not consider the case when there can
// be duplicate max digits, in this case, should swap the leftmost with the one lower
class Solution {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i; // last occurance of digit i 
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) { // larger one occured after, swap!
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
}
