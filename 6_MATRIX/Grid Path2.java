import java.util.*;

class Solution {
    static int MOD  = 1000000007;
    public int totalWays(int N, int M, int grid[][]) {
     
     int[][]dp = new int[N][M];
     for(int [] row : dp){
         Arrays.fill(row, -1);
     }
      
     return solve(0 , 0 , grid , dp , N , M);
    }
    
    public int solve(int x , int y , int [][] grid , int [][] dp, int N , int M){
    
       //Boundary Condition:-
         if(x < 0 || x >= N || y < 0 || y >= M || grid[x][y] == 1){
             return 0;
         }
          
          if(dp[x][y] != -1) {
              return dp[x][y];
          }
         
        
         if(x == N-1 && y == M-1){
             return 1;
         }
         
         int right = solve(x, y+1 , grid , dp , N , M);
         int down = solve(x+1, y , grid , dp , N , M);
         
         dp[x][y] = (right+down)%MOD;
         return dp[x][y];
         
         
    }
}