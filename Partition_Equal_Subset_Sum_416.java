class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum %2) == 1) { // sum & 1 == 1
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum+1]; // dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
        // as i-1, the 2-d dp can be reduced to one
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0 ; i <nums.length; i++) {
            for (int j = sum; j > 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
            }
        }

        return dp[sum];
    }
}
