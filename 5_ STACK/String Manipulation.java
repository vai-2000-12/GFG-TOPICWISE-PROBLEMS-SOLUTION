import java.util.*;
class Solution {
    static int removeConsecutiveSame(Vector<String> arr) {
       
       Stack<String> st = new Stack<>();
       
       for(String s : arr){
           
           if(!st.isEmpty() && s.equals(st.peek())){
               st.pop();
           }else{
               st.push(s);
           }
       }
       return st.size();
    }
}