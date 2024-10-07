class Node {
    int data;
    Node npx;

    Node(int x) {
        data = x;
        npx = null;
    }
}
class Solution {
    // function should insert the data to the front of the list
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        newNode.npx = head;
        return newNode;
    }

    // function to print the linked list
    static ArrayList<Integer> getList(Node head) {
        // Code Here.
        ArrayList<Integer> lst = new ArrayList<>();
         Node newNode = head;
        while(newNode!= null){
            lst.add(newNode.data);
            newNode = newNode.npx;
        }
        return lst;
    }
}