// Tomorrow for Submission in GFG Website
import java.util.*;
class Pair {
    int x;
    int y;
    int steps;

    public Pair(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}

class Solution {
    public int minSteps(int N, int M, int[][] A, int X, int Y) {
        
        if (A[0][0] == 0 || A[X][Y] == 0) {
            return -1;
        }

        // Directions for moving up, down, left, right
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new Pair(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int r = curr.x;
            int c = curr.y;
            int steps = curr.steps;

            // Check if we have reached the destination
            if (r == X && c == Y) {
                return steps; // Return the number of steps taken to reach (X, Y)
            }

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int new_r = r + dx[i];
                int new_c = c + dy[i];

                // Check boundary conditions and whether the cell is valid
                if (new_r >= 0 && new_r < N && new_c >= 0 && new_c < M 
                    && !visited[new_r][new_c] && A[new_r][new_c] == 1) {
                    queue.add(new Pair(new_r, new_c, steps + 1));
                    visited[new_r][new_c] = true; // Mark as visited
                }
            }
        }

        return -1; // If the destination is unreachable
    }
}
