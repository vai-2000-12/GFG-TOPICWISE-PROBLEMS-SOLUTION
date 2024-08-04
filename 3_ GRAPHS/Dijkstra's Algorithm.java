import java.util.*;

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int visit[]=new int[V];
        Arrays.fill(visit,Integer.MAX_VALUE);
        ArrayDeque<Integer>ans=new ArrayDeque<>();
        visit[S]=0;
        ans.add(S);
        
        while(!ans.isEmpty()){
            int node=ans.poll();
            for(ArrayList<Integer>it:adj.get(node)){
                int tempcurr=visit[node]+it.get(1);
                if(visit[it.get(0)]>tempcurr){
                   visit[it.get(0)]=tempcurr;
                    ans.add(it.get(0));
                }
            }
        }
        return visit;
    }
}
