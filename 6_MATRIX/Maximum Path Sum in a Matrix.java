       //User function Template for Java
class Solution {
    static int maximumPath(int N, int Matrix[][]) { 
        int[][] dp = new int[N][N];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            maxSum = Math.max(maxSum, MaxSum(0, i, N, Matrix, dp));
        }
        return maxSum;
    }
    
    public static int MaxSum(int x, int y, int N, int[][] Matrix, int[][] dp) {
        // Boundary Condition
        if (y < 0 || y >= N) {
            return 0;
        }
        
       
        if (x == N - 1) {
            return Matrix[x][y];
        }
        
       
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        
        // Recursive calls for the three possible moves
        int st1 = MaxSum(x + 1, y, N, Matrix, dp);
        int st2 = MaxSum(x + 1, y - 1, N, Matrix, dp);
        int st3 = MaxSum(x + 1, y + 1, N, Matrix, dp);
        
     
        dp[x][y] = Matrix[x][y] + Math.max(st1, Math.max(st2, st3));
        
        return dp[x][y];
    }
}