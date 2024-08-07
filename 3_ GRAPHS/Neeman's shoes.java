import java.util.*;

class Pair implements Comparable<Pair>
{
    int dist, node;
    Pair(int n, int d)
    {
        dist = d;
        node = n;
    }
    
    public int compareTo(Pair p)
    {
        return dist-p.dist;
    }
    
}

class Solution
{
    public String exercise(int N, int M, ArrayList<ArrayList<Integer>> A, int src, int dest, int X)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        ArrayList<Pair> adj[] = new ArrayList[N];
        
        for(int i=0; i<M; i++)
        {
            int n1 = A.get(i).get(0);
            int n2 = A.get(i).get(1);
            int d = A.get(i).get(2);
            //System.out.println(n1 + " " + n2 + " " + d);
            if(adj[n1]==null)
            {
                adj[n1] = new ArrayList<>();
            }
            
            if(adj[n2]==null)
            {
                adj[n2] = new ArrayList<>();
            }
            
            adj[n1].add(new Pair(n2, d));
            adj[n2].add(new Pair(n1, d));
            
        }
        
        pq.add(new Pair(src, 0));
        
        boolean visited[] = new boolean[N];
        
        while(pq.isEmpty()==false)
        {
            
            Pair p = pq.poll();
            
            visited[p.node] = true;
            
            if(p.node==dest)
            {
                if(p.dist<=X)
                {
                    return "Neeman's Cotton Classics";
                }
                else
                {
                    return "Neeman's Wool Joggers";
                }
            }
            
            for(Pair nei : adj[p.node])
            {
                if(visited[nei.node]==false)
                {
                    pq.add(new Pair(nei.node, nei.dist + p.dist));
                }
            }
            
            
        }
        
        
        return " ";
        
    }
}