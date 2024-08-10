import java.util.*;

class GetMin
{
    //Function to push all the elements into the stack.
    public static Stack<Integer> _push(int arr[],int n)
    {
      Stack<Integer> st = new Stack<>();
      st.push(arr[0]);
      
      for( int i = 1 ; i < n ; i++){
          if(st.peek() < arr[i]){
              st.push(st.peek());
          }else {
              st.push(arr[i]);
          }
      }
           return st;
    }
    
    //Function to print minimum value in stack each time while popping.
    static void _getMinAtPop(Stack<Integer>s)
    {
      while(! s.isEmpty()){
          System.out.print(s.pop() + " ");
      }
    }
}