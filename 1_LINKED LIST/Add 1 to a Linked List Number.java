//Tomorrow For Submission:-
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Solution {
    public Node addOne(Node head) {
        // code here.
        //Reverse LinkedList..
         Node temp = ReverseLinkedList(head);
         Node dummy = new Node(-1); 
         Node curr = dummy;
        
        int carry = 1;
        
        while (temp != null) {
            int sum = carry + temp.data;
            carry = sum / 10;  
            
            Node new_Node = new Node(sum % 10);  
            curr.next = new_Node;
            curr = new_Node;
            
            temp = temp.next;
        }
        
        // If there's still a carry left, add a new node
        if (carry > 0) {
            curr.next = new Node(carry);
        }
        
        
        return ReverseLinkedList(dummy.next);
    }
    
    public Node ReverseLinkedList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        
        Node prev = null;
        Node curr = head;
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
