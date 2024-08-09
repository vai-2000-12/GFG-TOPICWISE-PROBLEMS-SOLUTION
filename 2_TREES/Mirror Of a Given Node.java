class Solution {
    public int findMirror(Node root, int target) {
        // Algorithm to get the Mirror of the given Node:
        // 1. Boundary Condition: If the Node is the root itself, return root.data.
        // 2. If a node's mirror does not exist, return -1. If root is null, return -1.


        // Edge case: if the root itself is the target
        if (root == null || root.data == target) {
            return root != null ? root.data : -1;
        }

        return traversal(root.left, root.right, target);
    }
    
    public int traversal(Node root1, Node root2, int target) {
     
        if (root1 == null || root2 == null) {
            return -1;
        }
        
     
        if (root1.data == target) {
            return root2.data;
        }
        if (root2.data == target) {
            return root1.data;
        }
        
        int ans1 = traversal(root1.left, root2.right, target);
        if (ans1 != -1) {
            return ans1;
        }
        
        int ans2 = traversal(root1.right, root2.left, target);
        return ans2;
    }
}
