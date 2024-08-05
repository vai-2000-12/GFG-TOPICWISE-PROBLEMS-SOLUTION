class Solution {
    int findCity(int n, int m, int[][] edges,int distanceThreshold)
    {
        //n -- nodes 
        // m -- edges:
        int[][]dist = new int[n][n];
        
        for( int i = 0 ; i < n ; i++){
           for( int j  = 0 ; j < n ; j++){
               dist[j][i] = Integer.MAX_VALUE;
           }
        }
        
        for(int i =0 ; i < m ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            dist[u][v] = w;
            dist[v][u] = w;
        }
        
        for( int i =0 ; i < n ; i++){
            dist[i][i] = 0;
        }
        
        // Now Applying the Floyd Warshall Algorithm :-
        
        for( int k = 0 ; k < n ; k++){
            for( int i = 0 ; i < n ; i++){
                for( int j = 0 ; j < n ;j++){
                  if(dist[i][k]!= Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]){
                      dist[i][j] = dist[i][k] + dist[k][j];
                  }  
                }
            }
        }
        
        
        int cityNo = -1;
        int CityCount = n;
        
        for(int i =0 ; i < n ; i++){
           int cnt = 0;
          for(int j = 0 ; j < n ; j++){
                if(dist[i][j] <= distanceThreshold)
                   cnt++;
              }
          if(cnt <= CityCount){
             CityCount = cnt;
             cityNo = i;
          }
        }
        return cityNo;
    }
}
