import java.util.Arrays;

class Graph {
    private int V; // Number of vertices
    private int[][] adjMatrix; // Adjacency matrix to store the graph

    // Constructor
    public Graph(int vertices) {
        this.V = vertices;
        adjMatrix = new int[V][V];

        // Initialize the adjacency matrix with a high value (infinity)
        for (int i = 0; i < V; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
        }
    }

    // Add edge to the graph (directed)
    public void addEdge(int u, int v, int weight) {
        adjMatrix[u][v] = weight;
    }

    // Method to find the shortest path with exactly k edges
    public int shortestPathWithKEdges(int[][] graph, int src, int dest, int k) {
        if(k == 0 && src == dest) return 0;
        if(k == 1 && graph[src][dest] !=Integer.MAX_VALUE) return graph[src][dest];
        if(k  < 0 ) return Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for( int i = 0 ; i < V ; i++){
            if(graph[src][i] != Integer.MAX_VALUE && src != i && dest != i){
                int rec = shortestPathWithKEdges(graph, i , dest, k-1);
                if(rec != Integer.MAX_VALUE){
                    res =  Math.min(res, graph[src][i]+ rec);
                }
            }
        }
        return res;
    }

    // Get the adjacency matrix
    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    // Driver code
    public static void main(String[] args) {
        // Number of vertices
        int V = 5;
        Graph graph = new Graph(V);

        // Adding edges to the graph
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 4, 7);

        int src = 0; // Source node
        int dest = 4; // Destination node
        int k = 3; // Number of edges

        // Calling the method with the adjacency matrix passed as a parameter
        int result = graph.shortestPathWithKEdges(graph.getAdjMatrix(), src, dest, k);
        System.out.println("Shortest path with exactly " + k + " edges: " + result);
    }
}
