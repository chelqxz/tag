class Solution {
    class TrieNode {
        int index;
        List<Integer> lst;
        TrieNode[] children;
        public TrieNode() {
            index = -1;
            lst = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addToTrie(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            searchTrie(res, root, words[i], i);
        }
        return res;
    }
    
    public void searchTrie(List<List<Integer>> res, TrieNode root, String word, int index) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (node.index >= 0) { //missed edge case = 0
                if (i < word.length() && isPalin(word, i, word.length()-1)) {
                    res.add(Arrays.asList(new Integer[]{index,node.index}));
                }
            }
            node = node.children[ind];
            if (node == null) return;
        }
        
        for (Integer cur : node.lst) {
            if (cur != index) {
                res.add(Arrays.asList(new Integer[]{index, cur}));
            }
        }
        return;
    }
    
    public void addToTrie(TrieNode root, String word, int index) {
        TrieNode node = root;
        for (int j = word.length()-1; j >= 0; j--) {
            if (isPalin(word, 0, j)) {
                node.lst.add(index);
            }
            int ind = word.charAt(j) - 'a';
            if (node.children[ind] == null) 
                node.children[ind] = new TrieNode();
            node = node.children[ind];
        }
        node.index = index;
        node.lst.add(index);
    }
    
    public boolean isPalin(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
