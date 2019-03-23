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
 BFS
 
 
 Algorithm

At the root node, we will associate it with the code 1. Then, for each node with code v, 
we will associate its left child with code 2 * v, and its right child with code 2 * v + 1.

We can find the codes of every node in the tree in "reading order" (top to bottom, left to right) 
sequence using a breadth first search. (We could also use a depth first search and sort the codes later.)

Then, we check that the codes are the sequence 1, 2, 3, ... with no gaps. Actually, we 
only need to check that the last code is correct, since the last code is the largest value.
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1));
        int count = 0;
        int lastcode = -1;
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            count++;
            lastcode = cur.code;
            if (cur.node != null) {
                if (cur.node.left != null) queue.offer(new Node(cur.node.left, cur.code*2 ));
                if (cur.node.right != null) queue.offer(new Node(cur.node.right, cur.code*2 +1 ));
            }
            // System.out.println(lastcode + " "+count);
        }
        return lastcode == count;
    }
    
    class Node{
        TreeNode node;
        int code;
        public Node(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }
}
