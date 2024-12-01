import java.util.*;
class Solution {
    public void solve(int n , int open , int close , String curr , List<String> res){
        
        //Boundary Condition:
        if(curr.length() == 2*n){
            res.add(curr);
        }
        
        if(open < n){
            solve(n , open+1 , close , curr+"(", res);
        }
        
        if(close < open){
            solve(n , open , close+1 ,curr+")", res);
        }
    }
    
    public List<String>AllParenthesis(int n) 
    {
        List<String> res = new ArrayList<>();
        solve(n , 0 , 0 , "", res);
        return res;
    }
}