

//User function Template for Java

class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // Use of Topological Sorting :-
        
        //Step 1 : To make the Graph using the prerequisites ArrayList:
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int [] indegree = new int[n];
        
        for( int i =0 ;i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        // Find the Indgree of every Node:
        for( int i =0 ; i< m; i++){
            int u = prerequisites.get(i).get(0);
            int v = prerequisites.get(i).get(1);
            adj.get(v).add(u);
            indegree[u]++;
        }
        
        int k =0;
        int [] ans = new int[n];
        
      
        Queue<Integer> q = new LinkedList<Integer>();
        for( int i =0 ;i < n ; i++){
            if(indegree[i] ==0)
              q.add(i);
        }
        
        
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[k++] = curr;
            for(int v : adj.get(curr)){
                if(--indegree[v] == 0){
                  q.add(v);
            }
        }
    }    
        
     if(k!= n) return new int[0];
     return ans;
        
    }
}