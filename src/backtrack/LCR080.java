package backtrack;

import java.util.ArrayList;
import java.util.List;

public class LCR080 {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // System.out.println("cur:" + cur);
        if(k == 0) {
            ans.add(new ArrayList<>(t));
            System.out.println(t.toString());
            return;
        }        
        
        if(t.size() + (n - cur + 1) < k || cur > n) {
            return;
        }
        
        t.add(cur);
        dfs(cur + 1, n, k - 1);
        t.remove(t.size() - 1);
        dfs(cur + 1, n, k);
    }


    public void dfs1(int cur, int n, int k) {
        if (t.size() + (n - cur + 1) < k) {
            return;
        }
        if(t.size() == k) {
            ans.add(new ArrayList<>(t));
            System.out.println(t.toString());
            return;
        }

        t.add(cur);
        dfs1(cur + 1, n, k);
        t.remove(t.size() - 1);
        dfs1(cur + 1, n, k);
    }


    public static void main(String[] args) {
        new LCR080().combine(4, 2);
    }
}
