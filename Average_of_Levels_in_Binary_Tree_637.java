/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
* bug1 : used hashmap, no order on key
* bug2 : [2147483647,2147483647,2147483647] edge case , use double to store + can overflow
*/
class Solution {
    List<double[]> lst = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        helper(root, 0);
        List<Double> ans = new ArrayList<>();
        for (double[] entry: lst) {
            ans.add((double)entry[0]/((double)entry[1]));
        }
        return ans;
    }
    
    public void helper(TreeNode node, int depth) {
        if (node == null) return;
        if (depth >= lst.size()) lst.add(new double[]{node.val, 1});
        else {
            lst.get(depth)[0] = lst.get(depth)[0] + node.val;
            lst.get(depth)[1] = lst.get(depth)[1] + 1;
        }
        helper(node.left, depth+1);
        helper(node.right, depth+1);
    }
}
