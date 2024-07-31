class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int m = image.length;
        int n = image[0].length;
        
        int color = image[sr][sc];
        if(color != newColor){
            dfs(image ,sr, sc , color, newColor);
        }
        return image;
    }
    public void dfs( int [][] image , int r , int c , int color , int newColor){
         int m = image.length;
        int n = image[0].length;
        
        // Boundary Condition 
        if(r < 0 || c < 0  || r >= m || c >= n || image[r][c] != color || image[r][c] == newColor){
            return;
        }
        
        
        image[r][c] = newColor;
        
        dfs(image , r+1 , c , color , newColor);
        dfs(image , r , c+1 , color , newColor);
        dfs(image , r-1 , c , color , newColor);
        dfs(image , r , c-1 , color , newColor);
    }
}