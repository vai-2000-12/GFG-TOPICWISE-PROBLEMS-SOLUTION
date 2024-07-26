
import java.util.*;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
     
     boolean[] visited = new boolean[V];
     ArrayList<Integer> ans = new ArrayList<Integer>();
     Queue<Integer> q = new LinkedList<>();
     
      for( int i = 0 ; i < V ; i++)
           visited[i] = false;
           q.add(0);
           visited[0] = true;
           
          while(!q.isEmpty()){
               int u = q.poll();
                ans.add(u);
                for(int v : adj.get(u)){
                    if(!visited[v]){
                       visited[v] = true;
                       q.add(v);
                    }
                }
          }
           return ans;
    }
}