import java.util.*;

class Solution
{
   
    String reverseWords(String S)
    {
      int n = S.length();
      StringBuffer sb = new StringBuffer();
      Stack<Character> st = new Stack<>();
      
      for( int i = 0 ; i < n ; i++){
          
         char[] c = S.toCharArray();
          if(c[i]!= '.'){
              st.push(c[i]);
          }else{
          while(!st.isEmpty()){
               sb.append(st.peek());
               st.pop();
          }
          sb.append('.');
         }
      }
      while(!st.isEmpty()){
           sb.append(st.pop());
      }
       return sb.toString();
    }
}