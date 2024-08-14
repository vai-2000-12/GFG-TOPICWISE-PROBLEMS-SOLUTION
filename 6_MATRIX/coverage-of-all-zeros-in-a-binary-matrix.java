class Solution {
    public int findCoverage(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        
        for( int i = 0 ; i < m ; i++){
           for( int j = 0 ; j < n ; j++){
             if(matrix[i][j] == 0){
                 int l = j+1;
                 int d =  i+1;
                 int up = i-1;
                 int r = j-1;
                 
             if(l < n && matrix[i][l] == 1) count++;
             if(r >=0  && matrix[i][r] == 1)count++;
             if(up >= 0 && matrix[up][j] == 1) count++;
             if(d < m && matrix[d][j] == 1)count++;
             }
           }
        }
        return count;
    }
}