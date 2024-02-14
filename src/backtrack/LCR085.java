package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LCR085 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        String s = new String("123");
        int i = 123;
        
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int left, int right, int max) {
        if(cur.length() == 2 * max) {
            ans.add(cur.toString());
            return;
        }
        if(left < max) {
            cur.append('(');
            backtrack(ans, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(right < left) {
            cur.append(')');
            backtrack(ans, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
