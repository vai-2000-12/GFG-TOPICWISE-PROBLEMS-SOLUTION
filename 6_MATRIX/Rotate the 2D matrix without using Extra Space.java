class Solution {
    void rotateMatrix(int arr[][], int n) {
       
       for( int i = 0 ; i < n ; i++){
           for( int j = i+1 ; j < n ;  j++){
               int temp = arr[i][j];
               arr[i][j] = arr[j][i];
               arr[j][i]  = temp;
           }
       }
       
       //flliping the Colums:
       for( int i = 0 ; i < n; i++){
           int top = 0;
           int bottom = n-1;
           
           while(top  <  bottom){
               int tmp = arr[top][i];
               arr[top][i] = arr[bottom][i];
               arr[bottom][i] = tmp;
               top++;
               bottom--;
           }
       }
    }
}