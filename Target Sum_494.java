class Solution {
     public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) / 2);  // s+sum>>>1 same as (s+sum) / 2
    }   

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];  // sum 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];  // 每一个都必须包括 所以没有dp[i] 这个选项 （对比416）
        return dp[s];
    } 
}
