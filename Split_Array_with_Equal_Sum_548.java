/**
* idea: cumulative sum array and the idea to use set to store what needed to be checked later (like two sum)
* time complexity: O(n^2)
* bug1 : in the comment ; stored (j, sum) pair in a map, ignored the possibility that for one j there can be more than one possible sum. 
*/ 
class Solution {
    public boolean splitArray(int[] nums) {
        // (j , sum)
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>(); // bug , maybe for one j not only one sum possible !!!
        // k: n-2 j : n-4
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        for (int j = 3; j < n-3; j++) {
            // for (int i = 1; i+1 < j; i++) {
            //     int s1 = sum[j-1] - sum[i]; // array 的题就是test those index(every cases)
            //     int s2 = sum[i-1];
            //     if (s1 == s2) {
            //         map.put(j, s1);
            //     }
            // }
            HashSet<Integer> set = new HashSet<>(); // deal with a specific j
            for (int i = 1; i+1 < j; i++) {
                if (sum[j-1] - sum[i] == sum[i-1]) {
                    set.add(sum[j-1] - sum[i]);
                }
            }
            for (int k = j+2; k < n-1; k++) {
                if (sum[n-1] - sum[k] == sum[k-1] - sum[j]) {
                    if (set.contains(sum[k-1] - sum[j]))
                        return true;
                }
            }
            
        }
        
        // for (int j = 3; j < n-3; j++) {
        //     for (int k = j+2; k < n-1; k++) {
        //         int s1 = sum[n-1] - sum[k];
        //         int s2 = sum[k-1] - sum[j];
        //         if (s1 == s2) {
        //             if (map.containsKey(j) && map.get(j) == s1) return true;
        //         }
        //     }
        // }
        return false;
    }
}
