class Solution
{
    public static int ways(int n, int m)
    {
       int[][]dp = new int[n+1][m+1];
       int mod = 1000000007;
       
       for( int i =0 ; i <= n; i++){
           for( int j = 0 ;j<=m; j++){
              if(i==0 || j==0)
                  dp[i][j]=1;
               else
             dp[i][j] = (dp[i][j-1]+dp[i-1][j]) % mod;       
           }
       }
       return dp[n][m];
    }
}