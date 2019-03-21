/**
* two priority queue 295. Find Median From Data Stream.
*/
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> lo = new PriorityQueue<Integer>((a,b) -> b.compareTo(a));
        PriorityQueue<Integer> hi = new PriorityQueue(); // min heap
        int i = 0;
        // initialize the heaps
        while (i < k)
            lo.offer(nums[i++]);
        for (int j = 0; j < k/2; j++) {
            hi.offer(lo.peek());
            lo.poll();
        }
        int ptr = 0;
        while (true) {
            medians[ptr++] = (k%2==1? lo.peek() : ((double)lo.peek() + (double) hi.peek()) * 0.5); // check if odd or even
            if (i >= nums.length)  // stop criterion 
                break;
            int out_num = nums[i-k];
            int in_num = nums[i++];
            int balance = 0;
            
            // out_num exit
            balance += (out_num <= lo.peek() ? -1 : 1); // in lo -1, in hi +1
            map.put(out_num, map.getOrDefault(out_num,0)+1);
            
            //in_num enter 
            if (!lo.isEmpty() && in_num <= lo.peek()) {
                balance++; 
                lo.offer(in_num);
            } else {
                balance --;
                hi.offer(in_num);
            }
            if (balance < 0) { // lo need more valid number
                lo.offer(hi.poll());
                balance++;
            } 
            if (balance > 0) {
                hi.offer(lo.poll());
                balance--;
            }
            // remove invalid numbers that should be discarded from heap tops
            while (map.containsKey(lo.peek())){
                map.put(lo.peek(), map.get(lo.peek())-1);
                int key = lo.poll();
                if (map.get(key) == 0) map.remove(key);
            }
            while (!hi.isEmpty() && map.containsKey(hi.peek())) {
                map.put(hi.peek(), map.get(hi.peek())-1);
                int key = hi.poll();
                if (map.get(key) == 0) map.remove(key);
            }  
        }
        return medians;
    }
}
