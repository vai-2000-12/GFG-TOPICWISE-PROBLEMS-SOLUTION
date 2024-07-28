// This is Based on 0 based Indexing .....
class pair{
    
    int x;
    int y;
    int steps;
    
   public pair(int x , int y , int steps){
        this.x = x;
        this.y = y;
        this.steps = steps;
   }
}

class Solution
{
   public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
   {
     int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
     int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };  
       
     Queue<pair> q = new LinkedList<>();
     boolean[][] visited = new boolean[N][N];
     q.add(new pair(KnightPos[0], KnightPos[1], 0));
     visited[KnightPos[0]][KnightPos[1]] = true;
     
     while(!q.isEmpty()){
         pair curr =  q.poll();
          
          // Boundary Condition:-
         if(curr.x == TargetPos[0] && curr.y == TargetPos[1]){
              return curr.steps;
         }    
        
         for( int i = 0 ; i < 8 ; i++){
             
             int r = curr.x + dx[i];
             int c = curr.y + dy[i];
          
             if(isValid(r , c , N) && !visited[r][c]){
                 visited[r][c] = true;
                 q.add(new pair(r, c , curr.steps +1));
             }
         }
     }
     return -1;
   }
   public boolean isValid(int row , int col , int N){
       
        if( row < 0  || row >= N || col < 0  || col >= N){
            return false;
        }
        return true;
   }
}