// kind of a greedy solution
// when cnt  <0 , add 1 to ans
// in the end add abs(cnt) to ans
class Solution {
    public int minAddToMakeValid(String S) {
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                cnt++;
            }
            if (S.charAt(i) == ')') {
                cnt--;
            }
            if (cnt < 0) {
                ans += -cnt;
                cnt = 0;
            }
        }
        ans += cnt<0 ? -cnt : cnt;
        return ans;
    }
}
