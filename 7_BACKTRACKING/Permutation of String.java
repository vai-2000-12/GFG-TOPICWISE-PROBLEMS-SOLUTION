import java.util.*;


class Solution {

    private String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

    public void solve(String s, int indx, int n, Set<String> res) {
        // Base Condition:
        if (indx == n) {
            res.add(s); // Add to Set to ensure uniqueness
            return;
        }

        for (int i = indx; i < n; i++) {
            s = swap(s, indx, i);
            solve(s, indx + 1, n, res);
            s = swap(s, indx, i); // Backtrack
        }
    }

    public List<String> findPermutation(String s) {
        int n = s.length();
        Set<String> resSet = new HashSet<>(); 
        solve(s, 0, n, resSet);

        List<String> res = new ArrayList<>(resSet); 
        Collections.sort(res); 
        return res;
    }
}