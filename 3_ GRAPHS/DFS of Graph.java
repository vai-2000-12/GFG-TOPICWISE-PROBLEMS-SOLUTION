import java.util.*;
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfsUtil(0, adj, visited, ans); 
        return ans;
    }
    
    private void dfsUtil(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        visited[u] = true; 
        ans.add(u); 
        
        for (int v : adj.get(u)) {
            if (!visited[v]) { 
                dfsUtil(v, adj, visited, ans); 
            }
        }
    }
}