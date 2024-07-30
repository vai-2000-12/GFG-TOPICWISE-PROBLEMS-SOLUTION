import java.util.*;

class Solution {
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
         
        for(ArrayList<Integer>lst : adj){
          if(lst.size() %2 == 1){
               return false;
          }    
        }
        
        return true;
    }
}