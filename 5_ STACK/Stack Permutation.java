//Tomorrow For Submission:-
import java.util.*;

class Solution {
    public static int isStackPermutation(int n, int[] ip, int[] op) {
       Stack<Integer> st = new Stack<>();
       int j = 0;
       for( int i =0 ; i < n ; i++ ){
        
          st.push(ip[i]);
          
         while(!st.isEmpty() && st.peek() == op[j]){
              j++;
              st.pop();
         } 
       }
       
       if(st.isEmpty() && j == n){
           return 1;
       }
       return 0;
    }
}
            
