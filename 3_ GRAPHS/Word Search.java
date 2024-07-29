class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (DFS(0, i, j, board, visited, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean DFS(int index, int x, int y, char[][] board, boolean[][] visited, String word)
    {
        int m = board.length;
        int n = board[0].length;
        
        if (index == word.length()) {
            return true;
        }
        
        // Boundary Condition and visited check:
        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || word.charAt(index) != board[x][y]) {
            return false;
        }
        
        visited[x][y] = true;
        
        boolean right = DFS(index + 1, x + 1, y, board, visited, word);
        boolean down = DFS(index + 1, x, y + 1, board, visited, word);
        boolean left = DFS(index + 1, x - 1, y, board, visited, word);
        boolean up = DFS(index + 1, x, y - 1, board, visited, word);
        
        if (right || left || down || up) {
            return true;
        }
        
        visited[x][y] = false;
        return false;
    }
}
