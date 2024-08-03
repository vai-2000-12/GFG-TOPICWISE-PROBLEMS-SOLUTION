import java.util.*;

class Pair{
    int x;
    int y;
    int steps;
    
    Pair(int x , int y , int steps){
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
       int m = grid.length;
       int n = grid[0].length;
       
       boolean [][] visited = new boolean[m][n];
       int [][] ans = new int[m][n];
       Queue<Pair> q = new LinkedList<>();
       
        for(int i =0 ; i < m ; i++){
          for( int j = 0 ; j < n  ; j++){
              if(grid[i][j] == 1 &&!visited[i][j]){
                   q.offer(new Pair(i , j , 0));
                   visited[i][j] = true;
              }
          }
        }    
       
       int[] dx = {-1, 0 , 0, 1};
       int[] dy = {0,  -1 , 1, 0};
       
       while(!q.isEmpty()){
           Pair curr = q.poll();
           int r = curr.x;
           int c = curr.y;
           int dis = curr.steps;
           
           ans[r][c]  = dis;
           
           for( int i = 0 ; i < 4 ; i++){
               
               int nr = r + dx[i];
               int nc = c + dy[i];
               
               if(nr >=0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc] && grid[nr][nc] == 0){
                   q.add(new Pair(nr, nc , dis + 1));
                   visited[nr][nc] = true;
               }
           }
       }
       return ans;
    }
};