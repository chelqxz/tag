class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1);
        return ans;
    }
    
    
    public void helper(int n, int k, int cur) {
        if (k == 0) {
            ans.add(new ArrayList<>(curList)); // bug! need to create new list to add to the answer. otherwise same reference
            return;
        }
        if (cur == n+1) {
            return;
        }
        helper(n, k, cur+1); // cur not included
        curList.add(cur);
        helper(n, k-1, cur+1);
        curList.remove(curList.size()-1);
        return;
    }
}
