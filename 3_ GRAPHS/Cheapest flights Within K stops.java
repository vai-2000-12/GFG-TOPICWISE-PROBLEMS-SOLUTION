import java.util.*;

class Pair implements Comparable<Pair>{
    int node;
    int cost;
    int stops;
    
    public Pair(int node , int cost , int stops){
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
   @Override
    public int compareTo(Pair p){
        return this.cost - p.cost;
    }
}
class Solution {
   public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
       ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
       
       for( int i = 0 ; i < n ; i++){
           graph.add(new ArrayList<>());;
       }
       for( int [] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            
            graph.get(u).add(new Pair(v, w , 0));
       }
       
       
       int[]dis = new int[n];
       Arrays.fill(dis , Integer.MAX_VALUE);
       dis[src] = 0;
       
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       pq.add(new Pair(src , 0, 0));
       
       
       while(!pq.isEmpty()){
           Pair curr = pq.poll();
           
           int nod = curr.node;
           int cost = curr.cost;
           int steps = curr.stops;
           
           if(nod == dst){
               return cost;
           }
           
           
           if (steps > k) {
               continue;
           }

           for(Pair next : graph.get(nod)){
               int v = next.node;
               int new_cost = next.cost;
               
               if(cost + new_cost < dis[v] || steps+1 <= k){
                   dis[v] = cost + new_cost;
                   pq.add(new Pair(v, cost + new_cost, steps+1));
               }
           }
       }
       return dis[dst] == Integer.MAX_VALUE? -1 : dis[dst];
   }
}