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
 use queue to store the nodes list so can do in the dfs order
 */
public class Codec {
    String N = "N";
    String splitter = ",";
    // Encodes a tree to a single string.
    
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }
    
    public void buildString (StringBuilder sb, TreeNode root){
        if(root == null ) {
            sb.append(N).append(splitter);
        }else{
            sb.append(root.val).append(splitter);
            buildString(sb,root.left);
            buildString(sb,root.right); // 前半部分是left， 后半部分是right
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(); // why queue 
        queue.addAll(Arrays.asList(data.split(",")));
        return build(queue);
    }
    
    public TreeNode build(Queue<String> alst) {
        String val = alst.remove();
        
        if(val.equals("N")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = build(alst);
            root.right = build(alst);
            return root;
        }
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
