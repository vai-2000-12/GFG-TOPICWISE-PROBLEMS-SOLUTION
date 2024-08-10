import java.util.*;

class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<Integer>();
        
        while(!s.isEmpty()){
          int val =  s.pop();
          
           while(!temp.isEmpty() && temp.peek() >  val){
               s.push(temp.pop());
           }
           temp.push(val);
        }
        return temp;
        
    }
}