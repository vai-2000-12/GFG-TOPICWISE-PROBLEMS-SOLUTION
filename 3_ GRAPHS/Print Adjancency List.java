import java.util.*;

//User function Template for Java
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
         
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ans.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            ans.get(edge[0]).add(edge[1]);
            ans.get(edge[1]).add(edge[0]);
        }
        
        return ans;
                   
    }
}