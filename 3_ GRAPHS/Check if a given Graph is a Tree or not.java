import java.util.*;

class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
     
     ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
     
     for(int i =0 ; i < n ; i++){
         graph.add(new ArrayList<>());
     }
     
     for(int i = 0 ; i < m ; i++){
        graph.get(edges.get(i).get(0)).add(edges.get(i).get(1)); 
        graph.get(edges.get(i).get(1)).add(edges.get(i).get(0)); 
     }
                    
            if( m != n-1){
                return false;
            }  
            
             boolean [] visited = new boolean[n];
             dfs(0, graph, visited);

             for (boolean v : visited) {
                if (!v) {
                return false;
                 }
            }
        return true;
    }
    
    // Step 2 Algorithm to detect the cycle in a Undirected Graph
    public boolean isCycle(int n , ArrayList<ArrayList<Integer>> adj){
        
        boolean [] visited = new boolean[n];
        for( int i =0 ; i < n ; i++){
            if(!visited[i]){
                if(isCycleUtil(i , adj , visited , -1))
                  return true;
            }
        }
        return false;
    }
    
    public boolean isCycleUtil(int node , ArrayList<ArrayList<Integer>> adj, boolean[]visited , int parent){
        
        visited[node] = true;
        
        for( int neigh : adj.get(node)){
            if(!visited[neigh]){
                if(isCycleUtil(neigh , adj , visited , node)){
                    return true;
                }
            }else if(neigh != parent){
                return true;
            }
        }
        return false;
    }
    
    public void  dfs(int node  , ArrayList<ArrayList<Integer>> adj , boolean [] visited){
        visited[node] = true;
        
        for(int neigh : adj.get(node)){
            if(!visited[neigh]){
                dfs(neigh , adj , visited);
            }
        }
    }
}
