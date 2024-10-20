class Solution {
    public ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        // Generate the adjacency list for the graph
        List<List<Integer>> adj = generateGraph(v, edges);
        
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);
                res.add(component);
            }
        }
        
      return res;
    }
    
    public List<List<Integer>> generateGraph(int v, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int x = edge[1];
            // Add an edge between u and x (both directions for undirected graph)
            adj.get(u).add(x);
            adj.get(x).add(u);
        }
        return adj;
    }
    
    public void dfs(int node, List<List<Integer>> adj, boolean[] visited, ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfs(neigh, adj, visited, component);
            }
        }
    }
}
