import java.util.*;
class Solution
{
    public static int isPossible (int per[], int vac[], int n)
    {
        // your code here
        Arrays.sort(per);
        Arrays.sort(vac);
        
       for(int i=0;i<n;i++){
           if(vac[i]<per[i])
           return 0;
       }
       return 1;
    }
}