class Solution {
    public int subarraySum(int[] nums, int k) {
        // actually does not care where a sum occured
        // as long as i know the sum happend before and how many times it occured
        // 有点像 two sum
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))  // there exist (sum - k), what's between is k 
                count += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0 )+1);
        }
        return count;
    }
}
