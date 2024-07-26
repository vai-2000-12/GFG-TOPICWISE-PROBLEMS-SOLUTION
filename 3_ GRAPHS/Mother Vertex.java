import java.util.*;
class Solution
{
    //Function to find a Mother Vertex in the Graph.
 public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    Arrays.fill(visited, false);
    int mother = -1;

 
    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            dfs(i, adj, visited);
            mother = i;
        }
    }

   
    Arrays.fill(visited, false);
    dfs(mother, adj, visited);

    // Step 3: Check if all vertices are reachable from the potential mother vertex
    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            return -1; 
        }
    }
    return mother;
}

public void dfs(int s, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
    visited[s] = true;
 
    ArrayList<Integer> neighbors = adj.get(s);
    for (int neighbor : neighbors) {
        if (!visited[neighbor]) {
            dfs(neighbor, adj, visited);
        }
    }
}

}