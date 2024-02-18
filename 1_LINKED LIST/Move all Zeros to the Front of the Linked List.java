//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
class Zeroes{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node head=null;
            Node curr=null;
            while(n-->0){
                int a=sc.nextInt();
                if(head==null){
                    head=new Node(a);
                    curr=head;
                }
                else{
                    Node temp=new Node(a);
                    temp.next=null;
                    curr.next=temp;
                    curr=temp;
                }
            }
            GfG g=new GfG();
            head = g.moveZeroes(head);
            while(head!=null){
                System.out.print(head.data+" ");
                head=head.next;
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/

class GfG{
    public Node moveZeroes(Node head){
        
        if( head == null || head.next == null){
             return head;
        }
        Node zero = new Node(-1); // Dummy node for zeros
        Node nonZero = new Node(-1); // Dummy node for non-zeros
        Node zeroTail = zero;
        Node nonZeroTail = nonZero;

        Node curr = head;

        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else {
                nonZeroTail.next = curr;
                nonZeroTail = nonZeroTail.next;
            }
            curr = curr.next;
        }

        // Connect the non-zero list to the zero list
        zeroTail.next = nonZero.next;

        // Set the end of the non-zero list to null to terminate the new list
        nonZeroTail.next = null;

        // The new head is the first node in the zero list
        return zero.next;
        
    }
}