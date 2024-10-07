class Node {
    int data;
     Node next;
     Node(int d)  { data = d;  next = null; }
 }
  Linked List class
 class LinkedList
 {
     Node head;  // head of list
 }
class Solution {
    Node intersectPoint(Node head1, Node head2) {
        // code here
        //Boundary Condition :
        if(head1 == null || head2 == null){
            return -1;
        }
        
        Node c1 = head1;
        Node c2 = head2;
        
        while(c1!= c2){
            c1 = c1.next;
            c2 = c2.next;
            
            if(c1 == c2){
              return c1;
            }
        }
        return c1;
    }
}