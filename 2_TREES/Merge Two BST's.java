import java.util.*;

class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> ans = new ArrayList<>();
        
        if(root1 == null & root2 == null){
            return new ArrayList<>();
        }
        
        traversal(root1 , ans);
        traversal(root2 , ans);
        
        Collections.sort(ans);
        return ans;
    
    }
     public void traversal(Node root, List<Integer> lst){
        
         if(root == null){
             return;
         }
         
         traversal(root.left , lst);
         lst.add(root.data);
         traversal(root.right , lst);
     }
}