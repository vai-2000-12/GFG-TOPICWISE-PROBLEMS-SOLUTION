//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0)
        {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Node node1 = null;
            Node temp1 = null;
            for (int i = 0; i < N; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node1 == null) {
                    node1 = newNode;
                    temp1 = node1;
                } else {
                    temp1.next = newNode;
                    temp1 = temp1.next;
                }
            }
    
            Node node2 = null;
            Node temp2 = null;
            for (int i = 0; i < M; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node2 == null) {
                    node2 = newNode;
                    temp2 = node2;
                } else {
                    temp2.next = newNode;
                    temp2 = temp2.next;
                }
            }
    
            GfG gfg = new GfG();
            Node result = gfg.mergeResult(node1, node2);
    
            printList(result);
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/* Structure of the node*/
/* class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class GfG
{
    Node mergeResult(Node node1, Node node2)
    {
        // Boundary Condition :-
	  // Step2 : Dono LinkedList ko Merge Kro
	   Node dummy = new Node(-1);
	   Node prev = dummy;
	   
	   Node c1 = node1;
	   Node c2 = node2;
	   
	   while(c1!= null && c2 != null){
	       if(c2.data < c1.data){
	           prev.next = c2;
	           c2 = c2.next;
	       }else {
	           prev.next = c1;
	           c1 = c1.next;
	       }
	       prev = prev.next;	       
	   }
	 
        prev.next = c1 != null ? c1 :c2;
	     
	     //  Step 3 : Reverse function call krdo At last Aur Answer Mil jayega 
	    return reverse(dummy.next);
	   
    }
    
    // Step 1 : Linked List ko Reverse Kro
    Node reverse(Node node){
        Node curr = node;
        Node prev = null;
        Node forw = null;
        
        while(curr != null){
             forw = curr.next;
             curr.next = prev;
             prev = curr;
             curr = forw;
        }
        return prev;
    }
}
