import java.util.*;

/*Complete the function below*/
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // Step 1 To find The Indegree of all the Nodes in the Graph:
        int [] indegree = new int[V];
        
         for (int i = 0; i < V; i++) {
        for (int node : adj.get(i)) {
            indegree[node]++;
        }
    }
        
        // Step 2 : Make a Queue And push all the Nodes having Indegree as '0'
          Queue<Integer> q = new LinkedList<>();
          for( int i =0 ; i < V ; i++){
              if(indegree[i] == 0){
                  q.add(i);
              }
          }
          
          int pos = 0;
          int [] ans = new int[V];
        
          //Step 3: Add the Vertex Having the Indegree as 0 in the Queue:
          Vector<Integer> v = new Vector<>();
          while(!q.isEmpty()){
               int u = q.poll();
                    ans[pos++] = u;
               for(int v1 : adj.get(u)){
                   if(--indegree[v1] == 0){
                          q.add(v1); 
                   }
               }
          }
         return ans;
    }
}