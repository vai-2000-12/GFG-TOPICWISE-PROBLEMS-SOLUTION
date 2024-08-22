class Node{
   int data;
   Node next;

   public Node(int data , Node next){
    this.data = data;
    this.next = null;
   }
}
class Solution {
    public Node insertAtBegining(Node head, int x) {
    if(head == null){
      Node new_Node = new Node(x);
      head = new_Node;
    }        
     Node new_Node = new Node(x);
     new_Node.next = head;
     head = new_Node;
           
     return head;
    }
}
