
class Node {
    int data;
    Node next;

    public Node (int data){
        this.data = data;
        this.next = null;
    }
}


class Solution {

    // Return the sum of last k nodes
    public int sumOfLastN_Nodes(Node head, int n) {
        int len = getlength(head);
        int remaining  = len - n;
        
        Node temp = head;
        int sum = 0;

        // Move the pointer to the first node to sum
        while (remaining > 0) {
            temp = temp.next;
            remaining--;
        }

        // Sum the last n nodes
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }

        return sum;
        
    }
    // Finding the Length of the Node 
    public int getlength(Node head){
        //Boundary Condition :
         if(head == null){
             return 0;
         }
         int count = 0;
         
         Node curr = head;
         
         while(curr != null){
             count++;
             curr = curr.next;
         }
         return count;
    }
}