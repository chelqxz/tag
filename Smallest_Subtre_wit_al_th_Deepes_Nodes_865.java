/**
recursion: what get from the child and what to do. base case: null or depth == maxdepth
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
// 1. contain all the deepest node
// 2. largest depth, means lowest
class Solution {
    HashMap<TreeNode, Integer> depth;
    int maxDepth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap<>();
        dfs(root,0); // find the depth for all node
        return answer(root);
    }
    
    // trick, pass the parent in as necessary
    // calculate the distance 
    public void dfs(TreeNode node, int d) {
        if (node != null) {
            depth.put(node, d);
            if (d > maxDepth) {
                maxDepth = d;
            }
            dfs(node.left, d+1);
            dfs(node.right, d+1);
        }
    }
    
    // do another traverse of the tree to find the node wanted
    public TreeNode answer(TreeNode node) {
        if (node == null || depth.get(node) == maxDepth)
            return node;
        TreeNode L = answer(node.left);
        TreeNode R = answer(node.right);
        if (L!=null && R != null) return node;
        if (L!= null) return L;
        if (R!= null) return R;
        return null;
    }
}



// method 2
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);
        Result L = dfs(node.left);
        Result R = dfs(node.right);
        if (L.depth > R.depth) return new Result(L.node, L.depth + 1); // in left tree
        if (L.depth < R.depth) return new Result(R.node, R.depth + 1); // in right tree
        return new Result(node, L.depth + 1); // current tree valid
    }
}

class Result {
    TreeNode node;
    int depth;
    Result(TreeNode n, int d) {
        node = n;
        depth = d;
    }
}
