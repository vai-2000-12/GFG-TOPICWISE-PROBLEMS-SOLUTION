import java.util.*;

class Solution
{
    //Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
      ArrayList<Integer> ans = new ArrayList<>();
       int m =  matrix.length;
      
         for( int i = 0 ; i < m ; i++){
            if(i %2 == 0){
                for(int j  = 0 ; j < m ; j++){
                    ans.add(matrix[i][j]);
                }
            }else{
                for( int j = m-1 ; j >= 0 ; j--){
                    ans.add(matrix[i][j]);
                }
            }
         }
       
       return ans; 
    }
}