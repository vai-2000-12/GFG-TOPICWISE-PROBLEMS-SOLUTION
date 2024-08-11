import java.util.*;

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	  int[] a = new int[n];
	  Arrays.fill(a, -1);
	  
	  Stack<Integer> st  = new Stack<>();
	  for( int i = 0 ; i < n ; i++){
	      
	      while(!st.isEmpty() && arr[st.peek()] > arr[i]){
	          a[st.pop()] = arr[i];
	      }
	      st.push(i);
	  }
	  return a;
	} 
}
