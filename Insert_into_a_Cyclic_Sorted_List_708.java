/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/


/**
* bug: need the first min node and last max node! <- 应该一起找 
* not elegant code at all, but should be optimal since O(n) algorithm
*/
class Solution {
    HashSet<Node> v = new HashSet<>();
    int minVal = Integer.MAX_VALUE;
    int maxVal = Integer.MIN_VALUE;
    
    Node minNodePrev = null;
    Node minNode = null;
    
    Node maxNode = null;
    Node maxNodeNext = null;
    
    Node prevNode = null;
    Node nextNode = null;
    
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal, null);
            head.next = head;
            return head;
        }
        traverse(null, head, insertVal);
        Node node = new Node(insertVal, null); // duplicate value?
        if (prevNode != null) {
            prevNode.next = node;
            node.next = nextNode;
        } else if (insertVal <= minVal) { // bug1 {"$id":"1","next":{"$ref":"1"},"val":1} 1
            minNodePrev.next = node;
            node.next = minNode;
        } else if (insertVal >= maxVal) {
            maxNode.next = node;
            node.next = maxNodeNext;
        }
        return head;
    }
    
    public void traverse(Node prev, Node cur, int insertVal) { 
        if (minVal >= cur.val ) { // minNode being the first minnode
            if (minVal == cur.val) {
//                 if (minNodePrev == null) {
                    /**
                    {"$id":"1","next":{"$id":"2","next":{"$id":"3","next":{"$ref":"1"},"val":3},"val":3},"val":1} 4
                    */
//                 }
                if (minNodePrev == null || prev.val > cur.val) {
                    minVal = cur.val;
                    minNode = cur;
                    minNodePrev = prev;
                }
            } else {
                minVal = cur.val;
                minNode = cur;
                minNodePrev = prev; //null
            }
            
        }
        
        if (maxNode == prev) {
            maxNodeNext = cur;
        }
        if (maxVal <= cur.val ) {
            if (maxNode != null ) { 
                /**
                * {"$id":"1","next":{"$id":"2","next":{"$id":"3","next":{"$ref":"1"},"val":3},"val":3},"val":1}
4
                */
                
                // need to find the last max node (when there are multiple node having the same value)
                if (maxNode.next.val >= maxNode.val) {
                    maxVal = cur.val;
                    maxNode = cur;
                }
            } else {
                maxVal = cur.val;
                maxNode = cur;
            }
        }
        
        
        if (prev != null && prev.val <= insertVal && insertVal <= cur.val) { // bug2 : equal 
            //{"$id":"1","next":{"$id":"2","next":{"$id":"3","next":{"$ref":"1"},"val":5},"val":3},"val":1} 3
            prevNode = prev;
            nextNode = cur;
            return;
        }
        if (v.contains(cur)) {
            return;
        }
        if (prev != null) v.add(cur);
        traverse(cur, cur.next, insertVal);
    }
}
