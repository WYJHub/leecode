package backtrack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LCR081 {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, candidates, target);
        return ans;
    }

    public void dfs(int cur, int[] candidates, int target) {
        if(cur == candidates.length) {
            return;
        }
        // System.out.println(list.toString());
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            System.out.println(list.toString());
            return;
        }
        //直接跳过
        dfs(cur + 1, candidates, target);
        
        //选择当前数
        if(target - candidates[cur] >= 0) {
            list.add(candidates[cur]);
            dfs(cur, candidates, target - candidates[cur]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {10,1,2,7,6,1,5};
        int target = 8;
        new LCR081().combinationSum(candidates, target);
    }
}
