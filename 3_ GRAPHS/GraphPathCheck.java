public class GraphPathCheck {

    // Function to add an edge to the graph
    static void addEdge(int[][] graph, int u, int v) {
        graph[u][v] = 1; // Mark the edge from u to v
    }

    // DFS function to check if a path exists between two vertices
    static boolean dfs(int[][] graph, int src, int dest, boolean[] visited) {
       if(src == dest){
        return true;
       }
        
       visited[src] = true;
       for(int i = 0 ; i < graph.length ; i++){
        if(!visited[i] && graph[src][i] == 1){
            if(dfs(graph, i, dest, visited)){
                return true;
            }  
        }
       }
       
        return false;
    }

    public static void main(String[] args) {
        int vertices = 5;  // Number of vertices in the graph
        int[][] graph = new int[vertices][vertices]; // Graph represented as an adjacency matrix

        // Add some edges (directed)
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        // addEdge(graph, 3, 4);

        int src = 0;  // Source vertex
        int dest =4; // Destination vertex

        // Array to keep track of visited vertices
        boolean[] visited = new boolean[vertices];

        // Call dfs to check if there's a path between src and dest
        if (dfs(graph, src, dest, visited)) {
            System.out.println("Path exists between " + src + " and " + dest);
        } else {
            System.out.println("No path exists between " + src + " and " + dest);
        }
    }
}
