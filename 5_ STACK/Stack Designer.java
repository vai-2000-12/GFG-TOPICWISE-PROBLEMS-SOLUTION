import java.util.*;
//User function Template for Java
class GFG{

    public static Stack<Integer>_push(ArrayList<Integer> arr,int n)
{
     Stack<Integer> st = new Stack();
     
     for( int i =0 ; i< arr.size() ; i++){
         st.push(arr.get(i));
     }
    return st;
}

public static void _pop(Stack<Integer>s)
{
    while(!s.isEmpty()){
        System.out.print(s.pop()+ " ");
    }
   
    
}

}
