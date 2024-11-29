import java.util.*;
//User function template for JAVA
class Solution {
    // Helper function to find combinations
    public void sum(ArrayList<Integer> A, int target, int indx, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = indx; i < A.size(); i++){
            
            // Skip duplicates
            if (i > indx && A.get(i).equals(A.get(i - 1))) {
                continue;
            }
            // If the current number is greater than the target, skip it
            if (A.get(i) > target) {
                continue;
            }

            // Include the current number and recurse
            curr.add(A.get(i));
            sum(A, target - A.get(i), i, curr, res);
            curr.remove(curr.size() - 1); 
        }
    }

    // Function to return a list of indexes denoting the required combinations
    // whose sum is equal to the given number
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        // Sort the input to handle duplicates and make the logic cleaner
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Solution obj = new Solution();
        obj.sum(A, B, 0, curr, res);
        return res;
    }
}