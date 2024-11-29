import java.util.*;
class Solution {
    public void solve(int [] arr , int index , int n , int target , List<Integer> curr,  List<List<Integer>> res){
        //Boundary Condition:
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = index ; i < n ; i++){
          
          //Boundary Condition 1 :
          if( i > index && arr[i] == arr[i-1]) continue;
          
          if(arr[i] > target) break;
          
           curr.add(arr[i]);
           solve(arr , i+1 , n , target-arr[i], curr , res);
           curr.remove(curr.size()-1);
        
        }
    }
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(arr);
        int m = arr.length;
        solve(arr, 0, m , k , curr , res);
        return res;
    }
}