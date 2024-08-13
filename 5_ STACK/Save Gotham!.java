import java.util.*;

class Solution {
    // Function for finding maximum and value pair
    public static int save_gotham(int arr[]) {
        // Complete the function
        int n = arr.length;
        int mod = 1000000007;
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        for(int i = n-1 ; i >=0 ; i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            //Boundary Condition:-
            if(st.isEmpty()){
                sum+=0;
            }
            
            while(!st.isEmpty()){
                sum = (sum + arr[st.pop()]) % mod;
            }
            st.push(arr[i]);
        }
        return sum;
    }
}