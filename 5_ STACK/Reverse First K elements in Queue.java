import java.util.*;

class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
      
        Stack<Integer> st = new Stack<>();
        int count = 0;
        
        while(count != k){
           st.push(q.remove());
           count++;
        }
        
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        
        for( int i = 0 ; i < q.size()-k ; i++){
             q.add(q.remove());
        }
        return q;
    }
}
