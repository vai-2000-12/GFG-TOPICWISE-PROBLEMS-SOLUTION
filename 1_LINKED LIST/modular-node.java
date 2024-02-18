//{ Driver Code Starts
import java.util.*;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Iterator;
   
 class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    
class Modular
{
   static Node head;
    
     public static void addToTheLast(Node node) 
	{
		if (head == null) 
		{
			head = node;
		} else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;
		   temp.next = node;
		}
    }
    
    public static void main (String[] args) {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t-- > 0)
		 {
		     int n = sc.nextInt();
		     int a1 = sc.nextInt();
		     Node head = new Node(a1);
		     addToTheLast(head);
		     for(int i = 1; i < n; i++)
		     {
		         int a = sc.nextInt(); 
				 addToTheLast(new Node(a));
			 }
			 int k = sc.nextInt();
			GfG gfg = new GfG();
			System.out.println(gfg.moduarNode(head, k));
		     }
		 }
}

// } Driver Code Ends


/*node class of the linked list is as:
class Node {
	int data;
     Node next;
     Node(int key)
     {
         data = key;
         next = null;
     }
}
*/
// Your task is to complete the function
// function should return the modular Node
// if no such node is present then return -1
class GfG
{
    public static int moduarNode(Node head, int k)
    {
       Node curr = head;
         int ans = 0;
         int count = 1;
        while(curr != null){
            if(count %k == 0){
                ans = curr.data;
            } 
            curr = curr.next;
             count++;
        }
        
        if(ans == 0) return -1;
        return ans;
    }
}