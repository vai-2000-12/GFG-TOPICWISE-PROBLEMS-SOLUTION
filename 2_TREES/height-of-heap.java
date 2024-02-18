//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.heapHeight(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int heapHeight(int N, int arr[]){
         int cnt=0;
        while(N>1){
            cnt++;
            N=N/2;
        }
        return cnt;
    }
}