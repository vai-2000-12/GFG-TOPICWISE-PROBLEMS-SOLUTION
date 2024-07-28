class Solution
{
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        // Simple DFS :
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        
        for( int i = 0 ; i < m ; i++){
         for( int j = 0 ; j < n ; j++){
             if(grid[i][j] == 'X' && !visited[i][j]){
                  count++;
                 DFS(grid , i , j , visited);
             }
          }
        }
        return count;
    }
    public void DFS(char[][] grid , int x , int y , boolean [][] visited){
         int m = grid.length;
         int n = grid[0].length;
    
    // Boundary Condition:-
    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 'O' || visited[x][y]) {
        return;
    }
    
    visited[x][y] = true;
    
    DFS(grid, x + 1, y, visited);
    DFS(grid, x, y + 1, visited);
    DFS(grid, x - 1, y, visited);
    DFS(grid, x, y - 1, visited);
    }
}