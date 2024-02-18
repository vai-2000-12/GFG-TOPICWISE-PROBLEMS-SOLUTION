//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        
        // Reversed Both the List 
        Node c1 = ReverseLL(first);
        Node c2 = ReverseLL(second);
        
        Node dummy = new Node(-1);
        Node itr = dummy;
        
        int carry = 0;
        
         while(c1!= null || c2 != null || carry != 0){
             int sum = carry + (c1 != null ? c1.data :0) + (c2 != null ? c2.data :0);
               
              int digit = sum % 10;
              carry = sum/10;
              
              itr.next = new Node(digit);
              itr = itr.next;
              
            if (c1 != null) c1 = c1.next;
            if (c2 != null) c2 = c2.next;
         } 
         
        return ReverseLL(dummy.next);
    }
    // Step 1: Reverse The linked List:-
    static Node ReverseLL(Node head){
        
       if (head == null) return null;
         Node curr = head;
         Node prev = null;
         Node forw = null;
         
         while(curr !=  null){
            forw  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
         }
         return prev;
    }
     
}