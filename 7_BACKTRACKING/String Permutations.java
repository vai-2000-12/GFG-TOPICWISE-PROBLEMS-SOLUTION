import java.util.*;

class Solution {
    public String swap(String S, int i, int j) {
        char[] c = S.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return new String(c);
    }

    public void solve(String S, int indx, int n, ArrayList<String> lst) {

        // Boundary Comdition :
        if (indx == n) {
            lst.add(S);
            return; // Adding the Current String in the List
        }

        for (int i = indx; i < n; i++) {
            String swapped = swap(S, indx, i); // Perform the swap
            solve(swapped, indx + 1, n, lst); // Recur for the next index
        }
    }

    public ArrayList<String> permutation(String S) {
        ArrayList<String> res = new ArrayList<>();
        int n = S.length();
        solve(S, 0, n, res);
        Collections.sort(res);
        return res;
    }
}