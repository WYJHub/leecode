package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR082 {
    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        for(int num : candidates) {
            int size = freq.size();
            if(freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            }
            else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }

    public void dfs(int pos, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if(pos == freq.size() || target < freq.get(pos)[0]) {
            return;
        }
        //跳过当前值
        dfs(pos + 1, target);
        //遍历当前值
        int max = Math.min(target / freq.get(pos)[0], freq.get(pos)[1]);
        for(int i = 0; i < max; i++) {
            list.add(freq.get(pos)[0]);
            dfs(pos + 1, target - (i + 1) * freq.get(pos)[0]);
        }
        for(int i = 0; i < max; i++) {
            list.remove(list.size() - 1);
        }
    }
}
