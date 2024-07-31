import java.util.*;

class Solution {
    public String[] wordBoggle(char board[][], String[] dictionary) {
        List<String> foundWords = new ArrayList<>();
        
        for (String word : dictionary) {
            if (word_search(board, word)) {
                foundWords.add(word);
            }
        }
        
        String[] result = new String[foundWords.size()];
        return foundWords.toArray(result);
    }
    
    public boolean word_search(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, visited, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int x, int y, char[][] board, String word, boolean[][] visited, int count) {
        // Boundary Condition
        if (count == word.length()) {
            return true;
        }
        
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        
        if (visited[x][y] || board[x][y] != word.charAt(count)) {
            return false;
        }
        
        visited[x][y] = true;
        
        // Explore all 8 possible directions
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < 8; i++) {
            if (dfs(x + dx[i], y + dy[i], board, word, visited, count + 1)) {
                return true;
            }
        }
        
        visited[x][y] = false;
        return false;
    }
}
