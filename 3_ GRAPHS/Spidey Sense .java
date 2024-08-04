import java.util.*;
class Solution
{
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        int[][] ans = new int[m][n];
       for(int i = 0 ; i < m ; i++){
          for( int j = 0 ; j < n ; j++){
              if(mat[i][j] == 'W'){
                   ans[i][j] = -1;
              }
              else if(mat[i][j] == 'B'){
                  ans[i][j] = 0;
              }else {
                  ans[i][j] = -1;
              }
          } 
       }   
       
       Queue<Pair>q = new LinkedList<>();
       for( int i =0 ; i < m ; i++){
         for( int j = 0 ; j < n ; j++){
             if(mat[i][j] == 'B'){
                 q.add(new Pair(i , j));
             }
         }
       }
        
        int[] dx = {0 , 0 , -1 ,1};
        int [] dy = {1, -1 , 0 , 0};
       
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.x;
            int c = curr.y;
            
           for( int i = 0 ; i < 4 ; i++){
               int nr = r + dx[i];
               int nc = c + dy[i];
               
               if(nr >=0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == 'O'){
                    if(ans[nr][nc] == -1){
                        q.add(new Pair(nr , nc));
                        ans[nr][nc] = ans[r][c] + 1;  
                    }
               }
           }
        }
      
      return ans;
       
    }
}