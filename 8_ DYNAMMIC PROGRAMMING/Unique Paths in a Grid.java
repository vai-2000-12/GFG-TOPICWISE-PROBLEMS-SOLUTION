import java.util.*;
class Solution {
    static int MOD  = 1000000007;
     static int uniquePaths(int n, int m, int[][] grid) {
        
        int[][] dp = new int[n][m];
     
       for( int [] row : dp){
           Arrays.fill(row , -1);
       }
       
        return solve(grid , dp, 0 , 0, n , m);
         
     }
     public static int solve(int[][] grid, int [][] dp , int i , int j, int n , int m){
         
       if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
             return 0;
         }
         
         if(dp[i][j] != -1){
             return dp[i][j];
         }
         
         //BC-2
         if(i == n-1 && j == m-1){
             return 1;
         }
         
         //Now move on the Given Directions :
         int right = solve(grid , dp , i, j+1, n , m);
         int down = solve(grid , dp , i+1 , j , n , m);
         
         dp[i][j] = (right + down) % MOD;
         return dp[i][j];
     }
 };