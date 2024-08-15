
class Solution
{
    public int  Count(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int finalAns = 0;
        
        for( int i = 0 ; i < m ; i++){
            for( int j = 0 ; j < n ; j++){
                if(matrix[i][j] == 1){
                int count = 0;
                    
                 if(j + 1 < m && matrix[i][j+1] == 0)count++; //RD
                 if(j - 1 >= 0  && matrix[i][j-1] == 0)count++; //LD
                 if(i + 1 < n  && matrix[i+1][j] == 0)count++; //DoD
                 if(i - 1 >= 0 && matrix[i-1][j] == 0)count++; //UD
                 if(i-1 >=0 && j+1< m && matrix[i-1][j+1] == 0)count++; //UR
                 if(i-1 >= 0 && j-1 >=0 && matrix[i-1][j-1] == 0)count++; // UL
                 if(i+1 < n && j+1 < m && matrix[i+1][j+1] == 0)count++; // DR
                 if(i+1 < n && j-1 >= 0  && matrix[i+1][j-1] == 0)count++; //DL
                 
                 if(count % 2 == 0 && count > 0){
                     finalAns++;
                 }
               } 
           }    
        }
        return finalAns;
    }
}