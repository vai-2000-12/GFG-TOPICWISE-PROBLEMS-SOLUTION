class Solution
{
    public void  MakeZeros(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        
          for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int sum = 0;
                    
                    // Check left
                    if (j - 1 >= 0) {
                        sum += matrix[i][j - 1];
                        temp[i][j - 1] = 0;
                    }
                    
                    // Check right
                    if (j + 1 < n) {
                        sum += matrix[i][j + 1];
                        temp[i][j + 1] = 0;
                    }
                    
                    // Check up
                    if (i - 1 >= 0) {
                        sum += matrix[i - 1][j];
                        temp[i - 1][j] = 0;
                    }
                    
                    // Check down
                    if (i + 1 < m) {
                        sum += matrix[i + 1][j];
                        temp[i + 1][j] = 0;
                    }
                 
                    temp[i][j] = sum;
                }
            }
        }
        
        // Copy temp back to the original matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}