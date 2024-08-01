class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        
        int max = 0;
        
        for( int i = 0 ; i < m ; i++){
          for( int j = 0 ; j < n ; j++){
             if(grid[i][j] == 1){
              max = Math.max( max , DFS(i , j , grid));     
             }
           }
        }
        return max;
    }
    
    public int DFS(int x , int y , int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        
        //Boundary Condition:-
        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 || grid[x][y] == 2){
            return 0;
        }
        
        grid[x][y] =  0;
        
        int right = DFS(x , y+1, grid);
        int left = DFS(x , y-1 , grid);
        int down = DFS(x+1, y , grid);
        int up =  DFS(x-1, y , grid);
        int upRight = DFS(x-1, y+1 , grid);
        int upLeft = DFS(x-1 , y-1 ,grid);
        int downRight = DFS(x+1 , y+1 , grid);
        int downLeft = DFS(x+1 , y-1 , grid);
        
        return 1 + right + left + down + up + upRight + upLeft + downRight + downLeft;
        
    }
}    