class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

class Solution {
    // Function to sort the given doubly linked list using Merge Sort
    public DLLNode sortDoubly(DLLNode node) {
     // Boundary Condition :-
      if(node == null || node.next == null){
          return node;
      }
     
      DLLNode mid = getMid(node);
      DLLNode midNext = mid.next;
      
      mid.next = null;
      
      DLLNode left = sortDoubly(node);
      DLLNode right = sortDoubly(midNext);
      
      return merge(left, right);
        
    }
    // Getting the Middle Node from the List:-
    public DLLNode getMid(DLLNode node){
        DLLNode slow = node;
        DLLNode fast = node;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //Merge Doubly Linked List Code:-
     public  DLLNode merge(DLLNode a, DLLNode b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        DLLNode dummy = new DLLNode(0);
        DLLNode current = dummy;

        while (a != null && b != null) {
            if (a.data < b.data) {
                current.next = a;
                a.prev = current;
                a = a.next;
            } else {
                current.next = b;
                b.prev = current;
                b = b.next;
            }
            current = current.next;
        }

        if (a != null) {
            current.next = a;
            a.prev = current;
        } else {
            current.next = b;
            b.prev = current;
        }

        dummy.next.prev = null;
        return dummy.next;
    }
}