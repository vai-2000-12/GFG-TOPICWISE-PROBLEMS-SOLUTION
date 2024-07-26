import java.util.*;
/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recSt = new boolean[V];
        
        Arrays.fill(visited, false);
        Arrays.fill(recSt, false);
        
        for (int i = 0; i < V; i++) {
            if (!visited[i] && DFSRec(i, adj, visited, recSt)) {
                return true;
            }
        }
        return false;
    }
    
    // U --> This u is Current Node 
    public boolean DFSRec(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recSt) {
        if (recSt[u])
            return true;
        
        if (visited[u])
            return false;
        
        visited[u] = true;
        recSt[u] = true;
        
        for (int n : adj.get(u)) {
            if (DFSRec(n, adj, visited, recSt)) {
                return true;
            }
        }
        
        recSt[u] = false;
        return false;
    }
}