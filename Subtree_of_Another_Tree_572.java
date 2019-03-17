/**
* 花了很多时间debug
* 这种tree 的题目， 首先想到recursive的写。
* recursive的时候注意算法的简介， 一般结果不可能很长，很长很可能是思路不够简洁。
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        if (s == null && t == null) return true;
        if (s == null ^ t == null) return false;
        // return helper(s, t) || helper(s.left,t) || helper(s.right,t);
        return helper(s, t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    
    public boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if ((s == null ^ t == null) || s.val != t.val) return false;
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}
