import java.util.*;

public static ArrayList<Integer> displayList(Node head)
{
    // your code here
    ArrayList<Integer> al = new ArrayList<>();
    Node curr = head;
    
    while(curr!= null){
        al.add(curr.data);
        curr = curr.next;
    }
    return al;
}