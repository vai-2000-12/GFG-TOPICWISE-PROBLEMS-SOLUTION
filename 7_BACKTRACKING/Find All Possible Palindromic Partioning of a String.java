import java.util.*;

class Solution {
    public static boolean isPalindrome(String s , int start , int end){
        
       while(start < end){
           if(s.charAt(start) != s.charAt(end)) return false;
           start++;
           end--;
       }
        return true;
    }
    public static  void solve(String s , int index , ArrayList<String> curr, ArrayList<ArrayList<String>> res){
         //Boundary Condition
         if(s.length()== index){
             res.add(new ArrayList<>(curr));
             return;
         }
         
         for(int i = index ; i < s.length() ; i++){
             if(isPalindrome(s, index, i)){
                 
                 curr.add(s.substring(index, i+1));
                 //Recursion
                 solve(s, i + 1 , curr, res);
                 //bactrack
                 curr.remove(curr.size()-1);
             }
         }
    }
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> curr = new ArrayList<>();
        solve(S , 0 , curr , res);
        return res;
        
    }
};