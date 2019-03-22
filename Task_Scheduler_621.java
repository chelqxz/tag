class Solution {
    // "greedy": run the task with max left 
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks){
            map[c-'A']++;
        }
        // map to record the number of each tasks 
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(26,Collections.reverseOrder());// max heap 
        
        for(int i : map)
            if(i > 0)
                queue.add(i);
        
        int time = 0; 
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!queue.isEmpty()) {
                    if(queue.peek() > 1) // 　
                        temp.add(queue.poll()-1);
                    else
                        queue.poll();
                }
                time++;
                if(queue.isEmpty() && temp.size() ==0)
                    break;
            }
            queue.addAll(temp);
        }
        return time;
    }
}
