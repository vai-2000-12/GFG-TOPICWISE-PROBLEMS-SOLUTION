import java.util.*;

class solve {
    // Function to find all possible unique subsets.
    public static void solve(int[] arr, int n, int indx, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res) {

        res.add(new ArrayList<>(curr));

        for (int i = indx; i < n; i++) {

            if (i > indx && arr[i] == arr[i - 1])
                continue;

            curr.add(arr[i]);
            // Recursive Call
            solve(arr, n, i + 1, curr, res);
            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }
    public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Arrays.sort(arr);
        solve(arr, n, 0, curr, res);
        return res;
    }
}
