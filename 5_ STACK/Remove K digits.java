class Solution {
    public String removeKdigits(String S, int K) {
      
    StringBuffer ans = new StringBuffer();
    Stack<Character> st = new Stack<>();
    char[] c = S.toCharArray();

    for (int i = 0; i < c.length; i++) {
        while (!st.isEmpty() && K > 0 && c[i] < st.peek()) {
            st.pop();
            K--;
        }
        if (!st.isEmpty() || c[i] != '0') {
            st.push(c[i]);
        }
    }

    while (!st.isEmpty() && K > 0) {
        st.pop();
        K--;
    }

    if (st.isEmpty()) {
        return "0";
    }

    while (!st.isEmpty()) {
        ans.append(st.pop());
    }

    String res = ans.reverse().toString();
    return res.isEmpty() ? "0" : res;
    }
}