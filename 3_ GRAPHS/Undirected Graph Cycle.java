import java.util.*;

class Solution {
    // Function to detect cycle in an undirected graph.
     public boolean dfs(ArrayList<ArrayList<Integer>> adj , boolean [] visited , int node , int parent){
         visited[node] = true;
         
         for(int neigh : adj.get(node)){
            if(!visited[neigh]){
                 if(dfs(adj , visited , neigh , parent)){
                       return true;
                 }
              }else if(neigh != parent){
                   return true;
             }
         }
            return false;
     }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       
      int size = adj.size();
      boolean [] visited = new boolean[V];
      for( int i =0 ; i < V ; i++){
          if(!visited[i]){
             if(dfs(adj , visited , i , -1)){
                  return true;
             }  
          }
      }
          return false;
      
    }
}