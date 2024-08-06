// Tomorrows Submission:-
import java.util.*;

class Pair implements Comparable<Pair>{
    int x;
    int steps;
    
    public Pair(int x ,int steps){
        this.x = x;
        this.steps = steps;
    }
    public int compareTo(Pair p){
        return this.steps - p.steps;
    }
}
class Solution
{
    public String exercise(int N, int M, ArrayList<ArrayList<Integer>> A, int src, int dest, int X)
    {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for( int i =0 ; i < N ; i++){
            graph.add(new ArrayList<>());
        }
        
        for( int i = 0 ; i < M ; i++){
         
            int u = A.get(i).get(0);
            int v = A.get(i).get(1);
            int w = A.get(i).get(2);
            
          graph.get(u).add(new Pair(v, w));
        }
        
        boolean[]visited = new boolean[N];
        Arrays.fill(visited , false);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.x;
            int st = p.steps;
            
            if(node == dest){
                return st <= X ? "Neeman's Cotton Classics" : "Neeman's Wool Joggers";
            }
            
             if (!visited[node]) {
                visited[node] = true;
                
                for (Pair neighbor : graph.get(node)) {
                    if (!visited[neighbor.x]) {
                        pq.add(new Pair(neighbor.x, st + neighbor.steps));
                    }
                }
            }
          }
        
        return " ";
    }
}

/**
 * The `Solution` class contains a method `exercise` that uses Dijkstra's algorithm to find the
 * shortest path in a graph and returns a specific string based on the path length compared to a given
 * threshold.
 */