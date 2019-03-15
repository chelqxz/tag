/**
* clarify: same frequency? return order?
* priority queue / quickselect 
* bug: 1. PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); // (freq, value)
*       wrote b[0] - a[0] initially, should pop first the one with less freq.
*/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); // (freq, value)
        for (int key: map.keySet()) {
            pq.offer(new int[]{map.get(key), key});
            if (pq.size() > k) pq.poll();
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll()[1]);
        }
        return result;
    }
}

/**
* 
* bucket sort
* bug: 1. for (int i = nums.length; i >= 0 && result.size() < k; i--) 
*           not k>0, k--
*/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            if (buckets[map.get(key)] == null) 
                buckets[map.get(key)] = new ArrayList<>();
            buckets[map.get(key)].add(key);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }
        return result;
    }
}
