import java.util.*;

class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> St, int X) {
         Stack<Integer> stack = new Stack<>();
        while(!St.isEmpty())
        {
            stack.push(St.pop());
        }
        St.push(X);
        while(!stack.isEmpty())
        {
            St.push(stack.pop());
        }
        return St;
    }
}