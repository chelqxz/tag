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
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode ptr = left; // bug 1 : need to find the rightmost node before recusively call on left
        while (ptr != null && ptr.right != null) {
            ptr = ptr.right; 
        }
        TreeNode leftHead = increasingBST(left);
        TreeNode rightHead = increasingBST(right);
        root.left = null;
        root.right = rightHead;
        if (leftHead == null) return root; // deal with this condition first make the algorithm much clear
        ptr.right = root;
        return leftHead;
    }
}
