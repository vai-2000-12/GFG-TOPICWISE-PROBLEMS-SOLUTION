import java.util.*;

class Solution {

    public void sortIt(Long arr[]) {
     //code here.
        ArrayList<Long>li1=new ArrayList<>();
        ArrayList<Long>li2=new ArrayList<>();
        
        for(long i:arr){
            
            if(i%2==0) li2.add(i);
            
            else li1.add(i);
            
        }
        
        Collections.sort(li1);
        Collections.sort(li2);
        
        int k=0;
        
        for(int i=li1.size()-1;i>=0;i--){
            arr[k++]=li1.get(i);
        }
        
        for(int i=0;i<li2.size();i++){
            arr[k++]=li2.get(i);
        }
        
     }
}