

/*
Structure of node class is:
class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    
    public Node insertInMid(Node head, int data){
       // 1. Find the Middle Node first:-
        
        //Boundary Check:
        
        if(head ==null) return null;
        Node slow = head;
        Node fast = head.next;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node node = new Node(data);
        node.next =slow.next;
        slow.next = node;
        return head;
         
    }
}