class Node {
    int data;
     Node next;
     Node(int d)  { data = d;  next = null; }
 }
 class LinkedList
 {
     Node head;  // head of list
 }
 
class Intersect {
    
    int intersectPoint(Node head1, Node head2) {
        Node tmp1  = head1;
        Node tmp2  = head2;
        
        while (tmp1 != tmp2){
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
             
          if( tmp1 == tmp2){
              return tmp1.data;
          }     
            if(tmp1 == null){
                tmp1 = head2;
            }
            
            if(tmp2 == null){
                 tmp2 = head1;
            }
        }
        return tmp1.data;
    }
}