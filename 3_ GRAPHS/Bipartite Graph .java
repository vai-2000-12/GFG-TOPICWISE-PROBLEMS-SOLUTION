import java.util.*;

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        // Initialize the graph with V+1 lists (1-based indexing)
        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }
        
        
        for(int i = 0; i < adj.size(); i++){
            
            if (adj.get(i).size() < 2) {
                continue; // Skip if not a valid edge
            }
            int u = adj.get(i).get(0);
            int v = adj.get(i).get(1);
            
            if (u >= 0 && u <= V && v >= 0 && v <= V) {
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
        }
        
        int[] color = new int[V+1];
        Arrays.fill(color, -1);
        
        for(int i = 1; i <= V; i++){
            if(color[i] == -1){
                if(!check(i, graph, color, V)){
                    return false;
                }
            }
        }
        return true;    
    }
    
    public boolean check(int node, ArrayList<ArrayList<Integer>> graph, int[] color, int V){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int neigh : graph.get(curr)){
                if(color[neigh] == -1){
                    color[neigh] = 1 - color[curr];
                    q.add(neigh);
                } else if(color[neigh] == color[curr]){
                    return false;
                }
            }
        }  
        return true;
    }
}