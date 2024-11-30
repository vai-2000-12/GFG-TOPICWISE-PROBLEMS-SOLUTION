import java.util.*;

class Solution {
    public void solve(int [] arr , int n , int indx , ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res){
        res.add(new ArrayList<>(curr));
        
        for(int i = indx ; i < n ; i++){
            
            if(i > indx && arr[i] ==arr[i-1]) continue;
            
            curr.add(arr[i]);
            //Recursion
            solve(arr , n , i+1 , curr , res);
            //Backtrack
            curr.remove(curr.size()-1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        int n = arr.length;
        solve(arr , n , 0 , curr , res);
        return res;
    }
}