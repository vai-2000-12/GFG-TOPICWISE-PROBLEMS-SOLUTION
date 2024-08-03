import java.util.*;

class Solution
{
    //Function to find the level of node X.
    
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {  
       boolean[] visited = new boolean[V];
       int[]level = new int[V];
      
       int count = 0;
       
       DFS(adj, visited , 0 , level , 0);
       
       if(visited[X] == true){
           return level[X];
       }
       return -1;
    }
    public void DFS( ArrayList<ArrayList<Integer>> adj, boolean[]visited , int node , int[]level , int count){
       if(visited[node] == true){
           return;
       }    
       visited[node] = true;
       level[node] = count;
       
       for( int next : adj.get(node)){
           if(!visited[next]){
               DFS(adj , visited, next, level , count+1);
           }
       }
    }
}