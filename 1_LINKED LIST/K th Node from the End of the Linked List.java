{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} 
class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        int len = getLength(head);
        int rem = len-k;
        if(k > len) {
             return -1;
        }
        Node curr = head;
        for( int i = 0 ; i < rem ; i++){
            curr = curr.next;
        }
       return curr.data; 
    }
    
    // Find the Length of the Whole LinkedList:
    public int getLength(Node head){
        if(head == null){
            return 0;
        }
        int cnt = 0;
        Node curr = head;
        
        while(curr != null){
            cnt++;
            curr = curr.next;
        }
        return cnt;
    }
}
