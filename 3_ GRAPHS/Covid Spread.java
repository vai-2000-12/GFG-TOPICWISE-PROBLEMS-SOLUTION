import java.util.*;

class Solution{
    public int helpaterp(int[][] hospital) {
       int m = hospital.length;
       int n = hospital[0].length;
       Queue<int[]> q = new LinkedList<>();
       int time = 0;
       int freshPat = 0;
       
       for(int i =0 ; i < m ; i++){
         for(int j = 0 ; j < n ; j++){
            if(hospital[i][j] == 2){
                q.add(new int[] {i, j, 0});
            }
            if(hospital[i][j] == 1) freshPat++;
          }
       }
   
      int [] dx = {1, -1, 0 , 0};
      int [] dy = {0 ,0 , -1, 1};
      
      while(!q.isEmpty()){
          
           int [] curr = q.poll();
           int r = curr[0];
           int c = curr[1];
           int min = curr[2];
           
           time = min;
           
           for( int i =0 ; i < 4 ; i++){
               int nr = r + dx[i];
               int nc = c + dy[i];
               
               if(nr >= 0 && nc >= 0 && nr < m &&nc < n && hospital[nr][nc]==1){
                   hospital[nr][nc] = 2;
                   freshPat--;
                   q.add(new int[]{nr, nc ,min+1});
               }
           }
      }
      
      if(freshPat > 0){
          return -1;
      }else {
          return time;
      }
   }
}