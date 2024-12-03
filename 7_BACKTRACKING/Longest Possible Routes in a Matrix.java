
class Solution {
    public static int longestPath(int[][] mat, int n, int m, int xs, int ys, int xd, int yd) {
        // If the source or destination is blocked, return -1
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }

        // Visited matrix to keep track of visited cells
        boolean[][] visited = new boolean[n][m];

        // Helper function to perform backtracking
        return findLongestPath(mat, n, m, xs, ys, xd, yd, visited);
    }

    private static int findLongestPath(int[][] mat, int n, int m, int x, int y, int xd, int yd, boolean[][] visited) {
        // Base case: reached destination
        if (x == xd && y == yd) {
            return 0;
        }

        // Mark the current cell as visited
        visited[x][y] = true;

        // Initialize max path length
        int maxLength = -1;

        // Arrays to represent 4 possible movements (up, down, left, right)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Explore all 4 directions
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // Check if the move is valid
            if (isValidMove(mat, n, m, newX, newY, visited)) {
                // Recursively find the longest path from the new cell
                int pathLength = findLongestPath(mat, n, m, newX, newY, xd, yd, visited);
                if (pathLength != -1) {
                    maxLength = Math.max(maxLength, 1 + pathLength);
                }
            }
        }

        // Backtrack: unmark the current cell
        visited[x][y] = false;

        return maxLength;
    }

    private static boolean isValidMove(int[][] mat, int n, int m, int x, int y, boolean[][] visited) {
        return x >= 0 && x < n && y >= 0 && y < m && mat[x][y] == 1 && !visited[x][y];
    }
}