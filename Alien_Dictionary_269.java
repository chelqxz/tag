/**
* clarify: You may assume all letters are in lowercase.
* thought of graph and topological sort
* did not know how to do topo sort
*/

/**
* method 0: 
* Runtime: 33 ms, faster than 5.07% of Java online submissions for Alien Dictionary.
  Memory Usage: 34.5 MB, less than 93.06% of Java online submissions for Alien Dictionary.
*/
class Solution {
    HashMap<Character, List<Character>> map = new HashMap<>();
    HashMap<Character, Integer> degree = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    public String alienOrder(String[] words) {
        for (String word: words){
            for (char ch: word.toCharArray()) {
                degree.put(ch, 0);
            }
        }
        for (int i = 0; i < words.length-1; i++) {
            int ptr = 0;
            char[] w1 = words[i].toCharArray();
            char[] w2 = words[i+1].toCharArray();
            while (ptr<w1.length && ptr<w2.length) {
                char ch1 = w1[ptr];
                char ch2 = w2[ptr];
                if (ch1 == ch2) {
                    ptr++;
                    continue;
                }
                map.computeIfAbsent(ch1, k->new ArrayList<>()); // bug : missed k -> 
                if (map.get(ch1).add(ch2)) {// directed graph, topological sort
                    degree.put(ch2, degree.getOrDefault(ch2,0)+1);
                }
                break; 
            }
        }
        topological();
        return (sb.length() == degree.size()) ? sb.toString() : ""; 
    }
     
    public void process(String a, String b) { // a comes before b
        if (a.length() == 0 || b.length() == 0) return; 
        char ch1 = a.charAt(0);
        char ch2 = b.charAt(0);
        if (ch1 == ch2)  // initially wrong, when they equal, no process move forward with next character
            process(a.substring(1), b.substring(1));
        else {
            map.computeIfAbsent(ch1, k->new ArrayList<>()); // bug : missed k -> 
            if (map.get(ch1).add(ch2)) {// directed graph, topological sort
                degree.put(ch2, degree.getOrDefault(ch2,0)+1);
            }
        }
        
    }
    
    // graph directed <- topological sort not familiar
    public void topological() { // topological sort : not recursive
        Queue<Character> queue = new LinkedList<>();
        for (Character ch: degree.keySet()) {
            if (degree.get(ch) == 0) 
                queue.offer(ch);
        }
        
        while (!queue.isEmpty()) {
            Character ch = queue.poll();
            sb.append(ch);
            if (!map.containsKey(ch)) continue; // bug , missed to check here
            for (Character next: map.get(ch)) {
                int nextdeg = degree.get(next) - 1;
                if (nextdeg == 0) {
                    queue.offer(next);
                    degree.put(next, 0);
                } else {
                    degree.put(next, nextdeg);
                }
            }
        }
    }
}
