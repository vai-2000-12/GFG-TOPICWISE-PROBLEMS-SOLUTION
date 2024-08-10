import java.util.*;

class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
        
        while(!s1.isEmpty()){
            s2.push(s1.pop());
            
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        
    }
	
    
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
      
     while(s1.isEmpty()){
         return -1;
     }      
           
     return s1.pop();
	   
    }
}
