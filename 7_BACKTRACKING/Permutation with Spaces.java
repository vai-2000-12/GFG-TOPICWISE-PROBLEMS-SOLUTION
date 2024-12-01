import java.util.*;
class Solution{
    static void recursion(ArrayList<String> ans,String S,StringBuilder sb,int i)
    {
        if(i==S.length()-1)
        {
          sb.append(S.charAt(i));
          ans.add(sb.toString());
        
          //remove the last element
          sb.deleteCharAt(sb.length()-1);
          return;
          
        }
        
        recursion(ans,S,sb.append(S.charAt(i)+" "),i+1);
        //remove last 2 added element in backtracking
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        
        recursion (ans,S,sb.append(S.charAt(i)),i+1);

        // remove last element
        sb.deleteCharAt(sb.length()-1);
    }
    
    ArrayList<String> permutation(String S){
        // Code Here     
        ArrayList<String> ans=new ArrayList<>();    
        StringBuilder sb=new StringBuilder();
        recursion(ans,S,sb,0);
       return ans; 
    }
}