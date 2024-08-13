import java.util.*;
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
         Stack<Integer> stack = new Stack<>();
        List<Integer> as = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(stack.isEmpty())
            {
                as.add(-1);
            }else if(stack.size()>0 && stack.peek()<a[i])
            {
                 as.add(stack.peek());
            }else if(stack.size()>0 && stack.peek()>=a[i])
            {
                while(stack.size()>0 && stack.peek()>=a[i])
                {
                    stack.pop();
                }
                if(stack.size() == 0)
                {
                       as.add(-1);
                }else{
                       as.add(stack.peek());
                }
            }
            stack.push(a[i]);
        }
        return as;
    }
}