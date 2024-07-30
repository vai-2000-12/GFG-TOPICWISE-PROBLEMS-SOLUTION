import java.util.*;

class Solution {
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        // Initialize graph
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Add edges to the graph
        for (int i = 0; i < M; i++) {
            int u = Edges.get(i).get(0);
            int v = Edges.get(i).get(1);
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // Initialize visited array
        boolean[] visited = new boolean[N + 1];
        
      
        for (int i = 1; i <= N; i++) {
            if (checkHamiltonianPath(i, graph, visited, 1, N)) {
                return true;
            }
        }
        
        return false;
    }

    private boolean checkHamiltonianPath(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, int count, int N) {
        visited[node] = true;
        
        if (count == N) {
            return true;
        }
        
        for (int neigh : graph.get(node)) {
            if (!visited[neigh]) {
                if (checkHamiltonianPath(neigh, graph, visited, count + 1, N)) {
                    return true;
                }
            }
        }
        
        visited[node] = false;
        return false;
    }
}
// The `Hamiltonian Cycle` problem is checking whether a given graph contains a Hamiltonian cycle. A
// Hamiltonian cycle is a cycle that visits every vertex exactly once in a graph. The `check` method
// in the code is attempting to find a Hamiltonian path in the graph by recursively exploring all
// possible paths starting from each vertex. If a path is found that visits all vertices exactly once
// and returns to the starting vertex, then a Hamiltonian cycle exists in the graph.
