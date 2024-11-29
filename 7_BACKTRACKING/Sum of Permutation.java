import java.util.*;

class Solution {
    int mod = 1000000007;
    public int getSum(int arr[]) {
        ArrayList<ArrayList<Integer>> permutations = findPerm(arr);
        int sum = 0;
        for (ArrayList<Integer> perm : permutations) {
            int num = 0;
            for (int digit : perm) {
                num = (num * 10 + digit) % mod; 
            }
            sum = (sum + num) % mod; 
        }
        return sum;
    }

    public ArrayList<ArrayList<Integer>> findPerm(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;
        solve(arr, 0, n, res);
        return res;
    }

    public void solve(int[] arr, int index, int n, ArrayList<ArrayList<Integer>> lst) {
        
        // Boundary Condition:
        if (index == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : arr) {
                temp.add(num);
            }
            lst.add(temp);
            return;
        }

        for (int i = index; i < n; i++) {
            swap(arr, index, i); // Swap current element with the i-th element
            solve(arr, index + 1, n, lst); // Recurse for the next index
            swap(arr, index, i); // Backtrack to restore the original array
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}