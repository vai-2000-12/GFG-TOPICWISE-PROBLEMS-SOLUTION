import java.util.*;

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
      // Apply the simple dfs and move in 8 directions:
       int m = grid.length;
       int n = grid[0].length;
       int count = 0;
       
       for( int i = 0 ; i < m ; i++){
           for( int j = 0 ; j < n  ; j++){
                if(grid[i][j] == '1'){
                     count++;
                     dfs(grid , i  , j, m , n);
                }
           }
       }
       return count;
    }
    public void dfs(char[][] grid , int x , int y , int m , int n){
        
        if(!isValid(grid , x , y , m , n)){
            return;
        }
        
        grid[x][y] = '0';
        
        dfs(grid , x , y+1 , m , n);
        dfs(grid , x+1 , y , m , n);
        dfs(grid , x , y-1 , m , n);
        dfs(grid , x-1 , y , m , n);
        dfs(grid , x+1 , y-1 , m  , n);
        dfs(grid , x+1 , y+1 , m  , n);
        dfs(grid , x-1 , y+1 , m  , n);
        dfs(grid , x-1 , y-1 , m  , n);
        
    }
    public boolean isValid(char[][] grid , int x , int y , int m , int n){
        if(x >= 0 && y >=0 && x < m && y < n && grid[x][y] == '1'){
            return true;
        }
        return false;
    }
}