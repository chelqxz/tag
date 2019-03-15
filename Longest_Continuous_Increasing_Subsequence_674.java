/**
* sliding window, for loop for right boundary more elegant and easier code
*/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int l = 0;
        int len = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] <= nums[r-1]) {
                l = r;
            }
            if (r-l+1 > len) len = r-l+1;
        }
        return len;
    }
}
