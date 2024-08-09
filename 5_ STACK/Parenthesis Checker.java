import java.util.Stack;
class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
      Stack<Character> st = new Stack<>();
      char [] c = x.toCharArray();
      
      for( int i =0 ; i < x.length() ;i++){
           if(c[i] == '('){
               st.push(')');
           }else if(c[i] == '{'){
               st.push('}');
           }else if(c[i] == '['){
               st.push(']');
           }else if(st.isEmpty() || st.pop()!=c[i]){
               return false;
           }
      }
          if(st.isEmpty()){
                return true;
            }
      
      return false;
    }
}