import java.util.*;
class Solution 
{ 
    String sort(String s) 
    {
         // code here
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String str = "";
        for(int i=0;i<arr.length;i++){
            str = str+arr[i];
        }
        return str;
    }
} 