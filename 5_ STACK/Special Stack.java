import java.util.*;

class GfG {
    public void push(int a, Stack<Integer> s) {

        s.push(a);

    }

    public int pop(Stack<Integer> s) {

        int val = s.pop();
        return val;
    }

    public int min(Stack<Integer> s) {
        int min = Integer.MAX_VALUE;
        while (!s.isEmpty()) {
            int val = s.pop();
            min = Math.min(min, val);
        }
        return min;
    }

    public boolean isFull(Stack<Integer> s, int n) {

        if (s.size() == n) {
            return true;
        }
        return false;
    }

    public boolean isEmpty(Stack<Integer> s) {

        if (s.isEmpty() == true) {
            return true;
        }
        return false;
    }
}