class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}
class Solution {
    public void deleteAlt(Node head) {
       if(head == null){
           return;
       } 
       Node prev = head;
       Node now =  head.next;
       
       while(prev != null &&  now != null){
           
        prev.next = now.next;
          
         now = null;
         
        prev = prev.next;
        
        if(prev != null){
             now = prev.next;
        }
      }
    }
} 
    

