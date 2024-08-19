
class Solution {
    int minRow(int n, int m, int a[][]) {
           int count=m,index=0;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<m;j++){
                if(a[i][j]==1)cnt++;
            }
            if(cnt<count){
                count=cnt;
                index=i;
            }
        }
        return index+1;
    }
};