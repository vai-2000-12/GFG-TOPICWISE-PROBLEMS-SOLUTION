class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
       
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
       int count = 0;
       for( int i = 0 ; i < N ; i++){
           graph.add(new ArrayList<>());
       }
       int[]indegree = new int[N];
       
       for( int i =  0 ; i < P ; i++){
            
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            graph.get(u).add(v);
            indegree[i]++;
       }

       Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < N ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int neigh : graph.get(curr)){
                if(--indegree[neigh] == 0){
                    q.add(neigh);
                }
            }
        }
     return count == N;
    }
};