

/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Tree {
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
     ArrayList<Integer> res = new ArrayList<>();

    if (root == null) {
        return res;
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        int size = q.size();
        int sum = 0;

        for (int i = 0; i < size; i++) {
            Node rn = q.poll();

            while (rn != null) {
                if (rn.left != null) {
                    q.add(rn.left);
                }
                sum += rn.data;
                rn = rn.right;
            }
        }
        res.add(sum);
    }

    return res;
    }
}