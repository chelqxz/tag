/**
* brilliant idea! love the problem. 
* add to the result for the first node visited with depth == res.size() (the first node at that depth). and do the traverse from right to left (right node visited first)
* time complexity: O(n)
* space complexity: O(n)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    
    public void dfs(TreeNode node, List<Integer> res, int depth) {
        if (node == null) return;
        if (depth == res.size()) {
            res.add(node.val);
        }
        dfs(node.right, res, depth+1);
        dfs(node.left, res, depth+1);
        
    }
}
