import java.util.*;

class Solution {
    public int solve(int []arr , int n , int indx , int key , int []dp){
       //Boundary Condition--
       if(key == 0){
           return 1;
       }
       //Boundary Condition : -2 
       if(dp[key]!= -1){
           return dp[key];
       }
       
       // Simple Loop To check whether the Key Value is Less the Given Number than Subtract
       
       int count = 0;
       for(int num : arr){
           if(num <= key){
               count += solve(arr , n , indx , key-num, dp);
           }
       }
       return dp[key] = count;
               
    }
   int combinationSum4(int[] arr, int key) {
       // Complete this function
       int n = arr.length;
       int [] dp = new int[key + 1];
       Arrays.fill(dp , -1);
       return solve(arr , n , 0, key , dp);
   }
}