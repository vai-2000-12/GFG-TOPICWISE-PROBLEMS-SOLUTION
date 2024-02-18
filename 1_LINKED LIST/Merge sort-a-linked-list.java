//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
       
       if(head == null || head.next == null){
           return head;
       }
       
       // Middle of the Linked List:-
      
       // 3 --> 5   1--> 2 --> 4
       //  1-->2 --> 3 --> 4--> 5  
          
        Node mid = getMid(head);
        Node RightN = mid.next;
        mid.next = null;
       
       
        Node leftSorted = mergeSort(head);
        Node rightSorted = mergeSort(RightN);

        // Merge the sorted halves
        Node sortedList = MergeTwoSortedLL(leftSorted, rightSorted);

        return sortedList;
    }
    
   static Node MergeTwoSortedLL(Node left , Node right){
        
        Node res = null;
        
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(left.data  <= right.data){
              res = left;
              left.next = MergeTwoSortedLL(left.next , right);
        }else{
             res = right;
             right.next = MergeTwoSortedLL( left , right.next);
        }
        
        return res;
        
    }
    
    static Node getMid(Node head){
        
        if(head == null || head.next == null){
            return head;
        }
        
        Node slow = head;
        Node fast = head.next;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}


