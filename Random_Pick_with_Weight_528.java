/**
* data structure: hashmap
* time complexity: O(n) preprocessing, O(log(n)) pickindex
*/
class Solution {
    HashMap<Integer, Integer> map;
    int total;
    int[] keys;
    public Solution(int[] w) {
        map = new HashMap<>();
        total = 0;
        keys = new int[w.length];
        
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            map.put(total, i);
            keys[i] = total;
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int tmp = rand.nextInt(total);
        int i = Arrays.binarySearch(keys, tmp);
        if (i < 0) {
            i = -(i+1);
        } else {
            i = i+1; 
        }
        return map.get(keys[i]);
    }
}

