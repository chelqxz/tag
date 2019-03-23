/**
bit manipulation 
trick, know there is at most 32 bits, 32n would be a good way for better efficiency
for a bit: k*(n-k) , k for bit on 
*/

class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums.length == 0)
            return 0;
        int ans = 0, n = nums.length;
        int[] bits = new int[32];
        for (int num: nums) {
            int i = 0;
            while (num > 0) {
                bits[i] += (num & 1);
                num >>= 1;
                i++;
            }
        }
        
        for (int b : bits) {
            ans += b * (n-b);
        }
        return ans;
    }
}
