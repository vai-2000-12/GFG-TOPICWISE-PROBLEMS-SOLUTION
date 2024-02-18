/*Complete the function below*/
/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution
{
    //Function to count nodes of a linked list.
    public static int getCount(Node head)
    {
        Node curr = head;
        int count =0;   
        while(curr!= null){
            curr = curr.next;
            count++;
        }
        return count;
    }
}
    