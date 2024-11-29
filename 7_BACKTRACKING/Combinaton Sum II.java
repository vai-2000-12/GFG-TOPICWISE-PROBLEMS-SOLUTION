import java.util.*;

class Solution {
    public static void solve(int[] arr, int indx, int n, int target, List<Integer> lst, Set<List<Integer>> resSet) {
        if (target == 0) {
            resSet.add(new ArrayList<>(lst));
            return;
        }

        for (int i = indx; i < n; i++) {
            if (i > indx && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            lst.add(arr[i]);
            solve(arr, i + 1, n, target - arr[i], lst, resSet);
            lst.remove(lst.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        Set<List<Integer>> resSet = new HashSet<>();
        List<Integer> lst = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);
        solve(a, 0, n, s, lst, resSet);
        return new ArrayList<>(resSet);
    }
}