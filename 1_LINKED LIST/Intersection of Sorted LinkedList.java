class Solution {
    public static Node findIntersection(Node head1, Node head2) {
      //Boundary Condition :
       if(head1 == null || head2 == null){
           return null;
       }
        Node dummy=new Node(0);
        Node tail=dummy;
        Node temp1=head1;
        Node temp2=head2;
        
        while(temp2!=null && temp1!=null){
            if(temp1.data<temp2.data) temp1=temp1.next;
            else if(temp1.data>temp2.data)temp2=temp2.next;
            else{
                tail.next=new Node(temp1.data);
                tail=tail.next;
                temp1=temp1.next;
                temp2=temp2.next;
            }
        }
        return dummy.next;
    }
}