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

/**
* data structure: treemap
* time complexity: O(n) preprocessing, O(log(n)) pickindex
* space complexity: 相比于hashmap， 少了一个list去存key
*/
class Solution {
    TreeMap<Integer, Integer> map;
    int total;
    public Solution(int[] w) {
        map = new TreeMap<>();
        total = 0;
     
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            map.put(total, i);
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int tmp = rand.nextInt(total);
        int key = map.ceilingKey(tmp);// return the least key greater than or equal tmp
        if (key == tmp) { //如果没考虑这个会不能过。
            key = map.higherKey(tmp);
        }
        return map.get(key);
    }
}
