class Solution {
    long ans;
    void helper(int[][] arr,int k,int i,int j) {
        if(k < 0) return;
        if(i >= arr.length || j >= arr.length) return;
        if(i == arr.length-1 && j == arr.length -1 && k == arr[i][j]) ans++;
        helper(arr,k-arr[i][j],i + 1,j);
        helper(arr,k-arr[i][j],i,j + 1);
    }
    long numberOfPath(int n, int k, int [][]arr) {
        ans = 0;
        helper(arr,k,0,0);
        return ans;
    }
}