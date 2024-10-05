import java.util.*;

class Solution{
    // Function for finding maximum and value pair
    public static boolean isFit (int arr[], int brr[], int n) {
       Arrays.sort(arr);
       Arrays.sort(brr);
       int count = 0;
       for( int i = 0 ; i < n ; i++){
          if(arr[i] <= brr[i]){
            count++;   
          }
       }
    if(count == n){
      return true;
    }
      return false;
    }
}