 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 
class LinkedList
{
    Node head;  // head of list
}


class Solution {
    long DecimalValue(Node head) {
      long mod = 1000000007;
      
      Node curr = head;
      
      long sum = 0;
      
      while(curr!= null){
          sum = (sum * 2 + curr.data)%mod;
          curr = curr.next;
          
      }
      return sum;
        
    }
   
}