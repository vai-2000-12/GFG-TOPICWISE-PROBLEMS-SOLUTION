import java.util.*;
class Solution {

    public static int Selection(int arr[]) {
       long mod = 1000000007;
       long sum = 0;
       Arrays.sort(arr);
       for(int i =0 ; i < arr.length ; i++){
           sum+=arr[i]*i;
       }
       return (int)(sum % mod);
    }
}