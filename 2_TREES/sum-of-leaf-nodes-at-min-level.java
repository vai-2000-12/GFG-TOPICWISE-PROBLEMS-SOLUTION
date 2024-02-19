//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    int res = obj.minLeafSum(root);
		    System.out.println(res);
		}
	}
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution{
     // Method to calculate the minimum leaf sum of a binary tree
     public int minLeafSum(Node root){
        // If the root is null, return 0
        if(root==null)
            return 0;
        // Create a queue to perform level order traversal
        Queue<Node> q=new LinkedList<>();
        // Initialize the sum of leaf nodes to 0
        int ans=0;
        // Add the root node to the queue
        q.add(root);
        // Initialize a flag to check if the furthest leaf node has been reached
        int flag=1;
        // Iterate through the queue while it is not empty
        while(!q.isEmpty()){
            // Get the number of nodes at the current level
            int c=q.size();
            // Initialize a flag to check if a leaf node has been encountered
            int f=0;
            // Process each node at the current level and update the sum
            while(c-->0&&flag==1){
                // Get the node at the front of the queue
                Node temp=q.peek();
                // Remove the node from the queue
                q.poll();
                // If the node is a leaf node, update the sum
                if(temp.left==null&&temp.right==null){
                    ans+=temp.data;
                    f=1;
                }
                // Add the left child to the queue if it exists
                if(temp.left!=null){
                    q.add(temp.left);
                }
                // Add the right child to the queue if it exists
                if(temp.right!=null){
                    q.add(temp.right);
                }
                // If all nodes at the current level have been processed and a leaf node has been encountered,
                // set the flag to 0 to stop further iterations
                if(c==0&&f==1){
                    flag=0;
                }
            }
            // If the flag is 0, stop further iterations
            if(flag==0){
                break;
            }
        }
        // Return the minimum leaf sum
        return ans;
    }
}