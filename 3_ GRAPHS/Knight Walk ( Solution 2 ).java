import java.util.*;

class pair {
    int x;
    int y;
    int steps;

    public pair(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}

class Solution {
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

        Queue<pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        // Adjusting for 0-based indexing
        int startX = KnightPos[0] - 1;
        int startY = KnightPos[1] - 1;
        int targetX = TargetPos[0] - 1;
        int targetY = TargetPos[1] - 1;

        q.add(new pair(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            pair curr = q.poll();
            if (curr.x == targetX && curr.y == targetY) {
                return curr.steps;
            }

            for (int i = 0; i < 8; i++) {
                int r = curr.x + dx[i];
                int c = curr.y + dy[i];

                if (isValid(r, c, N) && !visited[r][c]) {
                    visited[r][c] = true;
                    q.add(new pair(r, c, curr.steps + 1));
                }
            }
        }
        return -1;
    }

    public boolean isValid(int row, int col, int N) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}
