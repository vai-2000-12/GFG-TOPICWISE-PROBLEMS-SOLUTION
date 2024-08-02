import java.util.*;
class pair{
    int node;
    int weight;
    
    public pair(int node , int weight){
      this.node = node;
      this.weight = weight;
    }

}
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
	    
	    //Draw a Graph first
	    ArrayList<ArrayList<pair>> graph = new ArrayList<>();
	    
	    for(int i = 0 ; i < N ; i++){
	      graph.add(new ArrayList<>());    
	    }
	    
	    for(int i = 0 ; i < M ; i++){
	       
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int w = edges[i][2];
	        
	        graph.get(u).add(new pair(v, w));
	    }
	    
	     int [] dist = new int[N];
	     Arrays.fill(dist , Integer.MAX_VALUE);
	     dist[0]  = 0 ;
	     
	   Queue<pair> q =  new LinkedList<>();
	   q.add(new pair(0 , 0));  
	    
	   while(!q.isEmpty()){
	     pair curr = q.poll();
	      int n = curr.node;
	      int weight = curr.weight;
	      
	      for(pair p : graph.get(n)){
	          int new_n = p.node;
	          int new_weight = weight + p.weight;
	          
	          if( new_weight < dist[new_n]){
	               dist[new_n] = new_weight;
	               q.add(new pair(new_n , new_weight));
	          }
	      }
	   } 
	   
	   for( int i =0 ; i < N; i++){
	       if(dist[i] == Integer.MAX_VALUE){
	           dist[i] = -1;
	       }
	   }
	    return dist;
	}
}