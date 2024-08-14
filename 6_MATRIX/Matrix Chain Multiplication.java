

//User function Template for Java

class Solution {
      
    static int solve(int N, int[] arr, int i, int j, int [][]dp) {
        // Boundary Condition:-
        if (i >= j) {
            return 0;
        }
        
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        
        // Apply the For loop :-
        int min = Integer.MAX_VALUE;
        
        for (int k = i; k <= j - 1; k++) {
            int tempAns = solve(N, arr, i, k, dp) + solve(N, arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
            
            if (tempAns < min) {
                min = tempAns;
            }
            
        }
         dp[i][j] = min;
         return min;
    } 
    
    static int matrixMultiplication(int N, int arr[]) {
        int [][] dp = new int[501][501];
         for( int [] row  : dp){
             Arrays.fill(row, -1);
         }
        return solve(N, arr, 1, N - 1, dp);
    }
}